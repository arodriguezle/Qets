import java.util.ArrayList;
import java.util.List;

public class Track {
	private String name;
	private double distance;
	private double seconds;
	private List<Rocket> rockets;

	public Track(String name, double distance, double seconds) {
		this.name = name;
		this.distance = distance;
		this.seconds = seconds;
		this.rockets = new ArrayList<Rocket>();
	}

	public String getName() {
		return this.name;
	}

	public double getDistance() {
		return this.distance;
	}

	public double getSeconds() {
		return this.seconds;
	}

	public void setSeconds(double seconds) {
		this.seconds = seconds;
	}

	public void addRocket(Rocket rocket) {
		this.rockets.add(rocket);
	}

}
