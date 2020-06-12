package application;

import java.util.List;
import java.util.Random;

import domain.Track;
import utilities.DataFileLoader;

public class TrackFactory {

	private static List<Track> tracks;

	public static Track getRandomTrack(DataFileLoader dfl) throws Exception {
		if (tracks == null) {
			dfl.loadTracks();
			tracks = dfl.getTracks();
		}
		Random rnd = new Random();
		return tracks.get(rnd.nextInt(tracks.size()));
	}
}