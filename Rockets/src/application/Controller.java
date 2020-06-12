package application;

import java.util.List;

import domain.Track;
import utilities.DataFileLoader;

public class Controller {
	private static Track track;
	private static DataFileLoader dfl;

	public Controller() throws Exception {
		dfl = DataFileLoader.getInstance();
	}

	public static void startRace() throws Exception {
		track.startRace();
	}

	public static void initiateTrack() throws Exception {
		track = TrackFactory.getTrack(dfl);
	}

	public static void initiateRockets() throws Exception {
		track.addRockets(RocketFactory.getRockets(dfl));
	}

	public static List<String> getResults() throws Exception {
		return track.getResults();
	}

	public Track getTrack() {
		return track;
	}
}
