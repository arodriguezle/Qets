import java.util.Scanner;

public class Main {
	private static int DETERMINEDSPEEDALGORIHTM = 1, BACKTRACKINGALGORITHM = 2;
	private static Scanner scan;

	public static void main(String[] args) throws Exception {
		Rocket ViperX = new Rocket("Viper X", 2500.0);
		Propeller propeller1 = new Propeller(50.0), propeller2 = new Propeller(20.0), propeller3 = new Propeller(38.0);
		ViperX.addPropeller(propeller1, propeller2, propeller3);
		Track track = new Track("FreeWorld", 1200.0, 18);
		track.addRocket(ViperX);
		System.out.println("Select Algorithm:   (1=determinedSpeedAlgorithm||2=backtrackingAlgorithm");
		scan = new Scanner(System.in);
		if (Integer.valueOf(scan.next()) == DETERMINEDSPEEDALGORIHTM) {
			track.startRace(1);
		} else if (Integer.valueOf(scan.next()) == BACKTRACKINGALGORITHM) {
			track.startRace(2);
		} else
			throw new Exception("Not selected algorithm");

	}
}
