package application;

import java.util.List;

import domain.*;
import persistence.DataFileLoader;

public class RocketFactory {
	
	DataFileLoader dfl;
	List<Rocket> rockets;
	
	public RocketFactory() throws Exception {
		dfl = new DataFileLoader();
		dfl.loadRockets();
		rockets = dfl.getRockets();
	}
}
