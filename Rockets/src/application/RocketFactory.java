package application;

import java.util.List;

import CapaPersistencia.DataFileLoader;
import domain.*;

public class RocketFactory {
	
	DataFileLoader dfl;
	List<Rocket> rockets;
	
	public RocketFactory() throws Exception {
		dfl = new DataFileLoader();
		dfl.loadRockets();
		dfl.loadTracks();
		rockets = dfl.getRockets();
	}
}
