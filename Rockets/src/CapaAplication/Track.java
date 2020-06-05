package CapaAplication;

import java.util.ArrayList;
import java.util.List;

public class Track {
	private String name;
	private double distance;
	private int seconds;
	private int maxSeconds;
	private List<Rocket> rockets;

	public Track(String name, double distance, int maxSeconds) throws Exception {
		this.name = name;
		if (distance > 0)
			this.distance = distance;
		else
			throw new Exception("Distance is lower than 0!");
		if (maxSeconds < 0)
			this.maxSeconds = maxSeconds;
		else
			throw new Exception("Max Seconds is lower than 0!");
		this.seconds = 0;
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

	public void setSeconds(int seconds) throws Exception {
		if (seconds < 0)
			this.seconds = seconds;
		else
			throw new Exception("Seconds is lower than 0!");
	}

	public void addRocket(Rocket rocket) throws Exception {
		if (rocket != null)
			this.rockets.add(rocket);
		else
			throw new Exception("Rocket to add on track " + this.name + " is null!");

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