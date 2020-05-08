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
		for (Propeller p : propellers)
			this.propellers.add(p);
	}

	public void updateSpeed(int time) {
		this.speed = speed + totalAceleration * 1;
	}

	public void updateTotalAceleration() {
		this.totalAceleration = 0;
		for (Propeller p : propellers)
			this.totalAceleration += p.getActualAcceleration();
	}

	public void updateDistance(int time) {
		this.distance = distance + speed * 1 + (1 / 2 * totalAceleration) * Math.pow(time, 2);
	}

	public void updateGas() {
		this.gas -= 0.02 * Math.pow(speed, 2);
	}

	public void update(int time) {
		updateTotalAceleration();
		updateSpeed(time);
		updateDistance(time);
		updateGas();
	}

	public double getMaxAceleration() {
		double maxAcc = 0;
		for (Propeller p : propellers)
			maxAcc += p.getMaxAcceleration();
		return maxAcc;
	}

	public void printPropieties() {
		for (int i = 0; i <= 18; i++) {
			if (breakingRules(1) == false) {
				double multi = (0.085);
				updatePropellersMultiplier(multi);
			} else {
				updatePropellersMultiplier(0.0);
			}
			update(i);
			System.out.println(
					"Distance = " + this.distance + "  ||  Acc= " + this.totalAceleration + "  ||  Gas= " + this.gas);
		}
	}

	public void algorithms(int time) {

	}

	private boolean breakingRules(int time) {
		double speed = (this.speed + totalAceleration * (1));
		if (this.gas - 0.02 * Math.pow(speed, 2) <= 0) {
			return true;
		}
		return false;
	}

	private void updatePropellersMultiplier(double multiplier) {
		for (Propeller p : propellers)
			p.setActualAcceleration(p.getMaxAcceleration() * multiplier);
	}
}
