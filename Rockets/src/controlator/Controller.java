package controlator;

import java.util.List;

import application.RocketFactory;
import application.TrackFactory;
import domain.Track;
import persistence.DataFileLoader;

public class Controller {
	private static TrackFactory TF;
	private static RocketFactory RF;
	private static Track track;
	private static DataFileLoader dfl = new DataFileLoader();

	public static void startRace() throws Exception {
		track.startRace();
	}

	public static void initiateTrack() throws Exception {
		TF = new TrackFactory(dfl);
		track = TF.getRandomTrack();
	}

	public static void initiateRockets() throws Exception {
		RF = new RocketFactory(dfl);
		track.addRockets(RF.getRockets());
	}

	public static List<String> getResults() throws Exception {
		return track.getResults();
	}

	public static String getTrack() {
		return track.toString();
	}

}
