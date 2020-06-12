package main;

import java.util.concurrent.TimeUnit;

import application.Controller;

public class Main {

	public static void main(String[] args) throws Exception {
		Controller controller = new Controller();
		System.out.println("\n---LOADING RANDOM TRACK---");
		Controller.initiateTrack();
		System.out.println(controller.getTrack().toString());
		System.out.println("\n------LOADING ROCKETS-----");
		Controller.initiateRockets();
		System.out.println("\n-------STARTING RACE------");
		Controller.startRace();
		showResults(controller);
		System.out.println("\n-------RACE FINISHED------");
		System.out.println("\n------SAVING RECORDS------");
		controller.saveNewRecord();
		System.out.println("\n-------RECORDS SAVED------");
	}

	public static void showResults(Controller controller) throws Exception {
		for (String s : Controller.getResults()) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println(s);
		}
	}
}
