package application;

import java.util.List;

import domain.Track;
import utilities.DataFileLoader;

public class Controller {
	private static Track track;
	private static DataFileLoader dfl;

	public Controller() {
		dfl = new DataFileLoader();
	}

	public static void startRace() throws Exception {
		track.startRace();
	}

	public static void initiateTrack() throws Exception {
		track = TrackFactory.getRandomTrack(dfl);
	}

	public static void initiateRockets() throws Exception {
		track.addRockets(RocketFactory.getRockets(dfl));
	}

	public static List<String> getResults() throws Exception {
		return track.getResults();
	}

	public static String getTrack() {
		return track.toString();
	}

}
