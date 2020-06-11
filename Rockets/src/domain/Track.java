package domain;

import java.util.ArrayList;
import java.util.List;

public class Track {
	private String name;
	private double distance;
	private int seconds;
	private int maxSeconds;
	private List<Rocket> rockets;
	private String[] moves;

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

	public String toString() {
		return "Track " + this.name + ": " + this.distance + "m   ||   " + this.maxSeconds + " seconds";
	}

	public void startRace() throws Exception {
		inicializeMoves();
		Algorithms algo = new Algorithms();
		for (Rocket rocket : this.rockets) {
			algo.calcAcceleration(this, rocket);
			for (int i = 0; i < algo.getAccelerations().length; i++) {
				if (algo.getAccelerations()[i] == -1)
					moves[i] = moves[i] + "\n" + rocket.toString() + " has no gas!";
				else if (algo.getAccelerations()[i] == -2)
					moves[i] = moves[i] + "\n" + rocket.toString() + " has finished!";
				else {
					rocket.update(i, algo.getAccelerations()[i]);
					moves[i] = moves[i] + "\n" + rocket.toString();
				}
				this.seconds++;
			}
			algo.reset();
			this.seconds = 0;
		}
	}

	private void inicializeMoves() {
		this.moves = new String[this.maxSeconds];
		for (int i = 0; i < moves.length; i++)
			moves[i] = "\nSecond " + (i + 1) + ":";
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

	public void reset() {
		this.seconds = 0;
	}

	public List<String> getResults() throws Exception {
		List<String> results = new ArrayList<String>();
		String cad = "";
		for (Rocket rocket : this.rockets) {
			rocket.reset();
			cad = cad + "\n" + rocket.toString();
		}
		results.add("\nSecond 0: " + cad);
		for (int i = 0; i < this.moves.length; i++)
			results.add(this.moves[i]);
		return results;
	}
}
