package domain;

import java.util.concurrent.TimeUnit;

public class Algorithms {

	private int[] accelerations;

	public Algorithms() {

	}

	public void calcAcceleration(Track track, Rocket rocket) {
		accelerations = new int[track.getSeconds()];

	}

	private void tooFastTooFuriousAlgorithm(Track track, Rocket rocket) throws Exception {
		while (track.getSeconds() <= track.getMaxSeconds()) {
			System.out.println("Second " + (track.getSeconds()) + ":");
			if (rocket.getDistance() < track.getDistance()) {
				if (rocket.getGas() <= 0) {
					System.out.println(rocket.getName() + ": HAS NO GAS at " + rocket.getDistance());
				}
				rocket.determinedAccelerationAlgorihtm((int) track.getSeconds(), 3);
				System.out.println(rocket.toString());
			} else {
				System.out.println(rocket.getName() + ": FINISHED at " + rocket.getDistance() + " with "
						+ rocket.getGas() + " gas left");
			}
			track.addSecond();
			System.out.println("---");
		}
	}

	private void suaveSuaveSuavesitoAlgorithm(Track track, Rocket rocket) {

	}

}
