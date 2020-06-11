package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import persistence.DataFileLoader;

public class Track {
	private String name;
	private double distance;
	private int seconds;
	private int maxSeconds;
	private List<Rocket> rockets;

	public Track(String name, double distance, int maxSeconds) throws Exception {
		this.name = name;
		if (distance >= 0)
			this.distance = distance;
		else
			throw new Exception("Distance is lower than 0!");
		if (maxSeconds >= 0)
			this.maxSeconds = maxSeconds;
		else
			throw new Exception("Max Seconds is lower than 0!");
		this.seconds = 0;
		this.rockets = new ArrayList<Rocket>();
	}

	public void startRace() throws Exception {
		boolean someoneLeft = true;
		while (this.getSeconds() <= this.getMaxSeconds() && someoneLeft == true) {
			TimeUnit.SECONDS.sleep(1);
			someoneLeft = isSomeoneLeft(this);
			System.out.println("Second " + (this.getSeconds()) + ":");
			for (Rocket rocket : this.getRockets()) {
				if (rocket.getDistance() < this.getDistance()) {
					if (rocket.getGas() <= 0) {
						System.out.println(rocket.getName() + ": HAS NO GAS at " + rocket.getDistance());
					}
						rocket.determinedAccelerationAlgorihtm((int) this.getSeconds(), 3);
						System.out.println(rocket.toString());
						// 3 (9m/s^2) is the acceleration that we tested that works
					} else {
					System.out.println(rocket.getName() + ": FINISHED at " + rocket.getDistance() + " with "
							+ rocket.getGas() + " gas left");
				}
			}
			this.addSecond();
			System.out.println("---");
		}
		System.out.println("---RACE FINISHED--- ");
	}

	private static boolean isSomeoneLeft(Track track) throws Exception {
		for (Rocket rocket : track.getRockets())
			if (rocket.getGas() > 0 && rocket.getDistance() < track.getDistance())
				return true;
		return false;
	}

	public String getName() {
		return this.name;
	}

	public double getDistance() {
		return this.distance;
	}

	public int getSeconds() {
		return this.seconds;
	}

	public int getMaxSeconds() {
		return this.maxSeconds;
	}

	public void addRocket(Rocket rocket) throws Exception {
		if (rocket != null)
			this.rockets.add(rocket);
		else
			throw new Exception("Rocket to add on track " + this.name + " is null!");

	}

	public void addRockets(List<Rocket> rockets) throws Exception {
		for (Rocket rocket : rockets) {
			if (rocket != null)
				this.rockets.add(rocket);
			else
				throw new Exception("Rocket to add on track " + this.name + " is null!");
		}

	}

	public List<Rocket> getRockets() {
		return this.rockets;
	}

	public void addSecond() {
		this.seconds++;
	}
}
