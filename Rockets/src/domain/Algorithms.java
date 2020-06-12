package domain;

public class Algorithms {

	private int[] accelerations;

	public Algorithms() {
	}

	public void calcAcceleration(Track track, Rocket rocket) throws Exception {
		accelerations = new int[track.getMaxSeconds()];
		myNinjaWayAlgorithm(track, rocket, rocket.getMaxAceleration());
	}

	public int[] getAccelerations() {
		return this.accelerations;
	}

	public void reset() {
		this.accelerations = null;
	}

	private void myNinjaWayAlgorithm(Track track, Rocket rocket, int acceleration) throws Exception {
		resetAll(rocket, track);
		while (track.getSeconds() < track.getMaxSeconds()) {
			if (rocket.getDistance() < track.getDistance() && rocket.getGas() >= 0)
				if (keepGoing(rocket, track))
					updateAll(rocket, acceleration, track.getSeconds());
				else
					updateAll(rocket, 0, track.getSeconds());
			else if (rocket.getGas() <= 0) {
				if (acceleration <= rocket.getMaxAceleration() && acceleration >= 0)
					myNinjaWayAlgorithm(track, rocket, acceleration - 1);// no es rendirà
			} else
				this.accelerations[track.getSeconds()] = -2;// ha acabat
			track.addSecond();
		}
	}

	private boolean keepGoing(Rocket rocket, Track track) throws Exception {
		if (rocket.getGas()
				- 0.02 * Math.pow(rocket.getSpeed() + rocket.getTotalAcceleration() * (track.getSeconds()), 2) > 0)
			return true;
		else
			return false;
	}

	private void resetAll(Rocket rocket, Track track) throws Exception {
		track.reset();
		rocket.reset();
	}

	private void updateAll(Rocket rocket, int acceleration, int index) throws Exception {
		rocket.update(acceleration);
		this.accelerations[index] = acceleration;
	}
}
