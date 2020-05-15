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
		// GENEREATES MORE ROCKETS
		for (int i = 0; i < 5; i++) {
			Rocket r = new Rocket("Gen " + i, Math.round(Math.random() * 2500));
			Propeller p1 = new Propeller(Math.round(Math.random() * 50)),
					p2 = new Propeller(Math.round(Math.random() * 50));
			r.addPropeller(p1, p2);
			track.addRocket(r);
		}
		//ENDS HERE
		System.out.println("Select Algorithm:   (1=determinedSpeedAlgorithm   2=backtrackingAlgorithm)");
		scan = new Scanner(System.in);
		int selection = Integer.valueOf(scan.next());
		if (selection == DETERMINEDSPEEDALGORIHTM)
			track.startRace(1);
		else if (selection == BACKTRACKINGALGORITHM) {
			Backtracking p = new Backtracking(ViperX, track);
			p.Backtracking();
		}	
		else
			throw new Exception("Not selected algorithm");
	}
}
