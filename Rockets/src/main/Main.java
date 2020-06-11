package main;

import java.util.Scanner;

import application.RocketFactory;
import application.TrackFactory;
import domain.*;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	static TrackFactory TF;
	static RocketFactory RF;

	public static void main(String[] args) throws Exception {
		
		System.out.println("---LOADING RANDOM TRACK--- ");
		
		TF = new TrackFactory();
		Track track = TF.randomTrack();
		
		System.out.println("---LOADING ROCKETS--- ");
		
		RF = new RocketFactory();
		track.addRockets(RF.getRockets());
		
		System.out.println("---RACE  STARTED--- ");
		System.out.println("---");
		
		track.startRace();
		
		System.out.println("---RACE FINISHED--- ");
		
	}
}
