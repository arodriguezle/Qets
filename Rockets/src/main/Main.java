package main;

import java.util.Scanner;

import domain.*;

public class Main {
	private static int DETERMINED_SPEED_ALGORIHTM = 1, BACKTRACKING_ALGORITHM = 2;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Rocket rocket1 = new Rocket("Viper X");
		GasTank gasTank = new GasTank(2500.0);
		rocket1.addGasTank(gasTank);
		Propellant propeller1 = new Propellant(50);
		Propellant propeller2 = new Propellant(20);
		Propellant propeller3 = new Propellant(38);
		rocket1.addPropellants(propeller1, propeller2, propeller3);
		Track track = new Track("FreeWorld", 1200.0, 18);
		track.addRocket(rocket1);
		System.out.println(
				"Select Algorithm:  \n1 => determinedSpeedAlgorithm   \n2 => backtrackingAlgorithm (Not finished yet, it is for the next delivery)");
		int selection = Integer.valueOf(scan.next());
		if (selection == DETERMINED_SPEED_ALGORIHTM)
			track.startRace(track, 1);
		else if (selection == BACKTRACKING_ALGORITHM) {
			track.startRace(track, 2);
		} else
			throw new Exception("Not selected algorithm");
	}
}
