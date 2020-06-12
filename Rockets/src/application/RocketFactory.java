package application;

import java.util.List;

import domain.Rocket;
import utilities.DataFileLoader;

public class RocketFactory {

	private static List<Rocket> rockets;

	public static List<Rocket> getRockets(DataFileLoader dfl) throws Exception {
		if (rockets == null) {
			dfl.loadRockets();
			rockets = dfl.getRockets();
		}
		return rockets;
	}
}
