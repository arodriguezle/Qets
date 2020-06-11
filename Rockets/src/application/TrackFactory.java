package application;

import java.util.List;

import CapaPersistencia.DataFileLoader;
import domain.*;

public class TrackFactory {
	
	DataFileLoader dfl;
	List<Rocket> tracks;
	
	public TrackFactory() throws Exception {
		dfl = new DataFileLoader();
		dfl.loadTracks();
		tracks = dfl.getTracks();
	}
}