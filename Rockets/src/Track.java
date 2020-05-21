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

	public List<Rocket> getRockets() {
		return this.rockets;
	}

	public void addSecond() {
		this.seconds++;
	}
}
