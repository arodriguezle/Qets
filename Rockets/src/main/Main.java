package main;

import controlator.Controller;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("---LOADING RANDOM TRACK--- ");
		Controller.initiateTrack();
		System.out.println("---LOADING ROCKETS--- ");
		Controller.initiateRockets();
		System.out.println("---STARTING RACE--- ");
		Controller.startRace();
		showResults();
		System.out.println("---RACE FINISHED--- ");
	}

	public static void showResults() throws Exception {
		for (String s : Controller.getResults()) {
			// TimeUnit.SECONDS.sleep(1);
			System.out.println(s);
		}
	}
}
