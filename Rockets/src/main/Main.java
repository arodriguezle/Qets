package main;

import java.util.concurrent.TimeUnit;

import application.Controller;

public class Main {

	public static void main(String[] args) throws Exception {
		Controller controller = new Controller();
		System.out.println("\n---LOADING RANDOM TRACK---");
		controller.initiateTrack();
		System.out.println(controller.getTrack().toString());
		System.out.println("\n------LOADING ROCKETS-----");
		controller.initiateRockets();
		System.out.println("\n-------STARTING RACE------");
		controller.startRace();
		showResults(controller);
		System.out.println("\n-------RACE FINISHED------");
		System.out.println("\n------SAVING RECORDS------");
		controller.saveNewRecord();
		System.out.println("\n-------RECORDS SAVED------");
	}

	public static void showResults(Controller controller) throws Exception {
		for (String s : controller.getResults()) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println(s);
		}
	}
}
