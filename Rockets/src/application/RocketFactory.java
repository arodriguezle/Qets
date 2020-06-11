package application;

import java.util.List;

import domain.Rocket;
import persistence.DataFileLoader;

public class RocketFactory  {

	private List<Rocket> rockets;

	public RocketFactory(DataFileLoader dfl) throws Exception {
		dfl.loadRockets();
		rockets = dfl.getRockets();
	}

	public List<Rocket> getRockets() {
		return rockets;
	}
}
