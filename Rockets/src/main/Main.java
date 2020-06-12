package main;

import java.util.concurrent.TimeUnit;

import application.Controller;

public class Main {

	public static void main(String[] args) throws Exception {
		Controller controller = new Controller();
		System.out.println("\n---LOADING RANDOM TRACK---");
		Controller.initiateTrack();
		System.out.println(Controller.getDataTrack());
		System.out.println("\n------LOADING ROCKETS-----");
		Controller.initiateRockets();
		System.out.println("\n-------STARTING RACE------");
		Controller.startRace();
		showResults(controller);
		System.out.println("\n-------RACE FINISHED------");

	}

	public static void showResults(Controller controller) throws Exception {
		for (String s : Controller.getResults()) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println(s);
		}
	}
}
