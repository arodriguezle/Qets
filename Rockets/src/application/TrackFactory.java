package application;

import java.util.List;
import java.util.Random;

import domain.Track;
import persistence.DataFileLoader;

public class TrackFactory {

	private List<Track> tracks;

	public TrackFactory(DataFileLoader dfl) throws Exception {
		dfl.loadTracks();
		tracks = dfl.getTracks();
	}

	public Track getRandomTrack() {
		Random rnd = new Random();
		return this.tracks.get(rnd.nextInt(this.tracks.size()));
	}
}