package main;

import java.util.List;
import java.util.concurrent.TimeUnit;
import application.*;
import domain.*;

public class Main {
	private static TrackFactory TF;
	private static RocketFactory RF;

	public static void main(String[] args) throws Exception {
		System.out.println("---LOADING RANDOM TRACK--- ");
		TF = new TrackFactory();
		Track track = TF.randomTrack();
		System.out.println(track.toString());
		System.out.println("---LOADING ROCKETS--- ");
		RF = new RocketFactory();
		System.out.println("---ADDING ROCKETS--- ");
		track.addRockets(RF.getRockets());
		System.out.println("---RACE  STARTED--- ");
		track.startRace();
		showResults(track.getResults());
		System.out.println("---RACE FINISHED--- ");
	}

	private static void showResults(List<String> results) throws InterruptedException {
		for (String s : results) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println(s);
		}
	}
}
