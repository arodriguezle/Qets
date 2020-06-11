package main;

import java.util.concurrent.TimeUnit;
import controlator.Controller;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("\n---LOADING RANDOM TRACK---");
		Controller.initiateTrack();
		System.out.println(Controller.getTrack());
		System.out.println("\n------LOADING ROCKETS-----");
		Controller.initiateRockets();
		System.out.println("\n-------STARTING RACE------");
		Controller.startRace();
		showResults();
		System.out.println("\n-------RACE FINISHED------");
	}

	public static void showResults() throws Exception {
		for (String s : Controller.getResults()) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println(s);
		}
	}
}
