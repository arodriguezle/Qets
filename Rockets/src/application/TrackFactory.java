package application;

import java.util.List;

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
}