package application;

import java.util.List;
import java.util.Random;

import domain.*;
import persistence.DataFileLoader;

public class TrackFactory {

	DataFileLoader dfl;
	List<Track> tracks;

	public TrackFactory() throws Exception {
		dfl = new DataFileLoader();
		dfl.loadTracks();
		tracks = dfl.getTracks();
	}
	
	public Track randomTrack() {
		Random rdm = new Random();
		return this.tracks.get(rdm.nextInt(this.tracks.size()));
	}
}