import java.util.ArrayList;
import java.util.List;

public class Track {
	private String name;
	private double distance;
	private int seconds;
	private int maxSeconds;
	private List<Rocket> rockets;

	public Track(String name, double distance, int maxSeconds) {
		this.name = name;
		this.distance = distance;
		this.seconds = 0;
		this.maxSeconds = maxSeconds;
		this.rockets = new ArrayList<Rocket>();
	}

	public String getName() {
		return this.name;
	}

	public double getDistance() {
		return this.distance;
	}

	public double getSeconds() {
		return this.seconds;
	}

	public int getMaxSeconds() {
		return this.maxSeconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public void addRocket(Rocket rocket) {
		this.rockets.add(rocket);
	}

	public void updateRockets() {
		for (Rocket r : this.rockets)
			r.update(this.seconds);
	}

	public void startRace(int i) throws Exception {
		System.out.println("---RACE  STARTED--- ");
		System.out.println("---");
		while (this.seconds < this.maxSeconds) {
			System.out.println("Second " + (this.seconds + 1) + ":");
			for (Rocket rocket : rockets) {
				if (rocket.getDistance() < this.distance) {
					if (rocket.getGas() <= 0) {
						System.out.println(rocket.getName() + ": HAS NO GAS");
					}
					if (i == 1)
						rocket.determinedAccelerationAlgorihtm(this.seconds, 9.18);
					else if (i == 2)
						throw new Exception("Not implemented yet");
				} else {
					System.out.println(rocket.getName() + ": FINISHED");
				}
			}
			this.seconds++;
			System.out.println("---");
		}
		System.out.println("---RACE FINISHED--- ");

	}
}
