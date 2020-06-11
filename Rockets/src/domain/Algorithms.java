package domain;

public class Algorithms {

	private int[] accelerations;

	public Algorithms() {

	}

	public void calcAcceleration(Track track, Rocket rocket) throws Exception {
		accelerations = new int[track.getMaxSeconds()];
		/*
		 * if (track.getMaxSeconds() >= 20) { suaveSuavesitoAlgorithm(track, rocket); }
		 * else if (rocket.getMaxAceleration() >= 40) { toFastToFuriusAlgorithm(track,
		 * rocket); } else { myNinjaWayAlgorithm(track, rocket,
		 * rocket.getMaxAceleration()); }
		 */
		myNinjaWayAlgorithm(track, rocket, rocket.getMaxAceleration());
		for (int i = 0; i < accelerations.length; i++)
			System.out.print(accelerations[i] + ",");
		System.out.println();

	}

	public int[] getAccelerations() {
		return this.accelerations;
	}

	public void reset() {
		this.accelerations = null;
	}

	private void toFastToFuriusAlgorithm(Track track, Rocket rocket) throws Exception {
		track.reset();
		while (track.getSeconds() < track.getMaxSeconds()) {
			if (rocket.getDistance() < track.getDistance() && rocket.getGas() >= 0) {
				if (rocket.getGas() - 0.02 * Math.pow(rocket.getSpeed() + rocket.getTotalAcceleration() * (1), 2) > 0) {
					rocket.update(track.getSeconds(), rocket.getMaxAceleration());
					this.accelerations[track.getSeconds()] = rocket.getMaxAceleration();
				} else {
					rocket.update(track.getSeconds(), 0);
					this.accelerations[track.getSeconds()] = 0;
				}
			} else if (rocket.getGas() <= 0) {
				this.accelerations[track.getSeconds()] = -1;// s'ha kdat sense gas
			} else {
				this.accelerations[track.getSeconds()] = -2;// ha acabat
			}
			track.addSecond();
		}
		rocket.reset();
	}

	private void suaveSuavesitoAlgorithm(Track track, Rocket rocket) throws Exception {
		track.reset();
		while (track.getSeconds() < track.getMaxSeconds()) {
			if (rocket.getDistance() < track.getDistance() && rocket.getGas() >= 0) {
				if (rocket.getGas() - 0.02 * Math.pow(rocket.getSpeed() + rocket.getTotalAcceleration() * (1), 2) > 0) {
					rocket.update(track.getSeconds(), (int) (rocket.getMaxAceleration() * 0.5));
					this.accelerations[track.getSeconds()] = (int) (rocket.getMaxAceleration() * 0.5);
				} else {
					rocket.update(track.getSeconds(), 0);
					this.accelerations[track.getSeconds()] = 0;
				}
			} else if (rocket.getGas() <= 0) {
				this.accelerations[track.getSeconds()] = -1;// s'ha kdat sense gas
			} else {
				this.accelerations[track.getSeconds()] = -2;// ha acabat
			}
			track.addSecond();
		}
		rocket.reset();

	}

	private void myNinjaWayAlgorithm(Track track, Rocket rocket, int acceleration) throws Exception {
		track.reset();
		while (track.getSeconds() < track.getMaxSeconds()) {
			if (rocket.getDistance() < track.getDistance() && rocket.getGas() >= 0) {
				if (rocket.getGas() - 0.02 * Math.pow(rocket.getSpeed() + rocket.getTotalAcceleration() * (track.getSeconds()), 2) > 0) {
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
