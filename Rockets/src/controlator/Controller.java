package controlator;

import java.util.List;

import application.RocketFactory;
import application.TrackFactory;
import domain.*;

public class Controller {
	private static TrackFactory TF;
	private static RocketFactory RF;
	private static Track track;

	public static void startRace() throws Exception {
		track.startRace();
	}

	public static void initiateTrack() throws Exception {
		TF = new TrackFactory();
		track = TF.randomTrack();
	}

	public static void initiateRockets() throws Exception {
		RF = new RocketFactory();
		track.addRockets(RF.getRockets());
	}

	public static List<String> getResults() throws Exception {
		return track.getResults();
	}

}
