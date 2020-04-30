import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String name;
	private double speed;
	private double distance;
	private double totalAceleration;
	private List<Propeller> propellers;
	private double gas;

	public Rocket(String name, double gas) {
		this.name = name;
		this.gas = gas;
		this.speed = 0;
		this.distance = 0;
		this.totalAceleration = 0;
		this.propellers = new ArrayList<Propeller>();
	}

	public String getName() {
		return this.name;
	}

	public double getGas() {
		return this.gas;
	}

	public double getSpeed() {
		return this.speed;
	}

	public double getDistance() {
		return this.distance;
	}

	public double getTotalAceleration() {
		return this.totalAceleration;
	}

	public void addPropeller(Propeller... propellers) {
		for (Propeller p : propellers) {
			this.propellers.add(p);
		}
	}

}
