package application;

import domain.Track;
import utilities.DataFileLoader;

public class TrackFactory {

	private static Track track;

	public static Track getTrack(DataFileLoader dfl) throws Exception {
		if (track == null) {
			track = dfl.getRandomTrack();
		}
		return track;
	}
}