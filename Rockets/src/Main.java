import java.util.Scanner;

public class Main {
	private static int DETERMINEDSPEEDALGORIHTM = 1, BACKTRACKINGALGORITHM = 2;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Rocket ViperX = new Rocket("Viper X", 2500.0);
		Propeller propeller1 = new Propeller(50.0), propeller2 = new Propeller(20.0), propeller3 = new Propeller(38.0);
		ViperX.addPropeller(propeller1, propeller2, propeller3);
		Track track = new Track("FreeWorld", 1200.0, 18);
		track.addRocket(ViperX);
		System.out.println("Select Algorithm:   (1=determinedSpeedAlgorithm   2=backtrackingAlgorithm)");
		int selection = Integer.valueOf(scan.next());
		if (selection == DETERMINEDSPEEDALGORIHTM)
			startRace(track, 1);
		else if (selection == BACKTRACKINGALGORITHM) {
			startRace(track, 2);
		} else
			throw new Exception("Not selected algorithm");
	}

	public static void startRace(Track track, int i) throws Exception {
		System.out.println("---RACE  STARTED--- ");
		System.out.println("---");
		boolean someoneLeft = true;
		while (track.getSeconds() <= track.getMaxSeconds() && someoneLeft == true) {
			someoneLeft = isSomeoneLeft(track);
			System.out.println("Second " + (track.getSeconds()) + ":");
			for (Rocket rocket : track.getRockets()) {
				if (rocket.getDistance() < track.getDistance()) {
					if (rocket.getGas() <= 0) {
						System.out.println(rocket.getName() + ": HAS NO GAS at " + rocket.getDistance());
					}
					if (i == 1) {
						rocket.determinedAccelerationAlgorihtm((int) track.getSeconds(), 9.18);
					} else if (i == 2) {
						throw new Exception("Not implemented yet");
					}
				} else {
					System.out.println(rocket.getName() + ": FINISHED at " + rocket.getDistance() + " with "
							+ rocket.getGas() + " gas left");
				}
			}
			track.addSecond();
			System.out.println("---");
		}
		System.out.println("---RACE FINISHED--- ");
	}

	private static boolean isSomeoneLeft(Track track) {
		for (Rocket rocket : track.getRockets())
			if (rocket.getGas() > 0 && rocket.getDistance() < track.getDistance())
				return true;
		return false;
	}
}
