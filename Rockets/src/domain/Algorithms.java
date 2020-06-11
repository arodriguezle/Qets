package domain;

public class Algorithms {

	private int[] accelerations;

	public Algorithms() {

	}

	public void calcAcceleration(Track track, Rocket rocket) throws Exception {
		accelerations = new int[track.getSeconds()];
		if (track.getMaxSeconds() >= 20) {
			suaveSuavesitoAlgorithm(track, rocket);
		} else if (rocket.getMaxAceleration() >= 40) {
			toFastToFuriusAlgorithm(track, rocket);
		} else {
			myNinjaWayAlgorithm(track, rocket, rocket.getMaxAceleration());
		}
	}

	public int[] getAccelerations() {
		return this.accelerations;
	}

	public void erase() {
		this.accelerations = null;
	}

	private void toFastToFuriusAlgorithm(Track track, Rocket rocket) throws Exception {
		while (track.getSeconds() <= track.getMaxSeconds()) {
			if (rocket.getDistance() < track.getDistance()) {
				if (rocket.getGas() <= 0) {
					this.accelerations[track.getSeconds()] = -1;// s'ha kdat sense gas
				}
				rocket.determinedAcceleration(track.getSeconds(), rocket.getMaxAceleration());
				// max in this case
			} else {
				this.accelerations[track.getSeconds()] = -2;// ha acabat
			}
			track.addSecond();
		}
	}

	private void suaveSuavesitoAlgorithm(Track track, Rocket rocket) throws Exception {
		while (track.getSeconds() <= track.getMaxSeconds()) {
			if (rocket.getDistance() < track.getDistance()) {
				if (rocket.getGas() <= 0) {
					this.accelerations[track.getSeconds()] = -1;// s'ha kdat sense gas
				}
				rocket.determinedAcceleration(track.getSeconds(), (int) (rocket.getMaxAceleration() * 0.25));
				// 0.25 of max speed
			} else {
				this.accelerations[track.getSeconds()] = -2;// ha acabat
			}
			track.addSecond();
		}
	}

	private void myNinjaWayAlgorithm(Track track, Rocket rocket, int acceleration) throws Exception {
		track.reset();
		while (track.getSeconds() <= track.getMaxSeconds()) {
			if (rocket.getDistance() < track.getDistance()) {
				if (rocket.getGas() <= 0) {
					if (acceleration <= rocket.getMaxAceleration() && acceleration >= 0)
						myNinjaWayAlgorithm(track, rocket, acceleration - 1);// no es rendirà
				}
				rocket.determinedAcceleration(track.getSeconds(), acceleration);
			} else {
				this.accelerations[track.getSeconds()] = -2;// ha acabat
			}
			track.addSecond();
		}
	}

}
