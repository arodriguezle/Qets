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
		Controller.showResults();
		System.out.println("---RACE FINISHED--- ");
	}
}
