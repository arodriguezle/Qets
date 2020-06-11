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
		track.reset();
		while (track.getSeconds() < track.getMaxSeconds()) {
			if (rocket.getDistance() < track.getDistance() && rocket.getGas() >= 0) {
				if (rocket.getGas() - 0.02
						* Math.pow(rocket.getSpeed() + rocket.getTotalAcceleration() * (track.getSeconds()), 2) > 0) {
					rocket.update(track.getSeconds(), acceleration);
					this.accelerations[track.getSeconds()] = acceleration;
				} else {
					rocket.update(track.getSeconds(), 0);
					this.accelerations[track.getSeconds()] = 0;
				}
			} else if (rocket.getGas() <= 0) {
				if (acceleration <= rocket.getMaxAceleration() && acceleration >= 0) {
					rocket.reset();
					myNinjaWayAlgorithm(track, rocket, acceleration - 1);// no es rendirà
				}
			} else {
				this.accelerations[track.getSeconds()] = -2;// ha acabat
			}
			track.addSecond();
		}
		rocket.reset();
	}
}
