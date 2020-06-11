package domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String name;
	private double speed;
	private double distance;
	private double totalAcceleration;
	private List<Propellant> propellants;
	private GasTank gasTank;

	public Rocket(String name, GasTank gasTank) throws Exception {
		this.name = name;
		if (gasTank != null)
			this.gasTank = gasTank;
		else
			throw new Exception("Gas Tank is null!");
		this.speed = 0;
		this.distance = 0;
		this.totalAcceleration = 0;
		this.propellants = new ArrayList<Propellant>();
	}

	public Rocket(String name) throws Exception {
		this.name = name;
		this.gasTank = null;
		this.speed = 0;
		this.distance = 0;
		this.totalAcceleration = 0;
		this.propellants = new ArrayList<Propellant>();
	}

	public void addGasTank(GasTank gasTank) {
		this.gasTank = gasTank;
	}

	public String getName() {
		return this.name;
	}

	public double getGas() throws Exception {
		if (this.gasTank != null)
			return this.gasTank.getGas();
		else
			throw new Exception("Gas Tank is null!");
	}

	public double getSpeed() {
		return this.speed;
	}

	public double getDistance() {
		return this.distance;
	}

	public double getTotalAcceleration() {
		return this.totalAcceleration;
	}

	public void addPropellants(List<Propellant> propellants) {
		for (Propellant p : propellants)
			this.propellants.add(p);
	}

	public void updateSpeed() {
		this.speed = speed + totalAcceleration;
	}

	public void updatetotalAcceleration() {
		this.totalAcceleration = 0;
		for (Propellant p : propellants)
			this.totalAcceleration += p.getActualAcceleration();
	}

	public void updateDistance() {
		this.distance = distance + speed + (1d / 2d * (double) totalAcceleration);
	}

	public void updateGas() throws Exception {
		this.gasTank.setGas(this.gasTank.getGas() - 0.02 * (double) Math.pow(speed, 2));
	}

	public void update(int acceleration) throws Exception {
		if (acceleration <= this.getMaxAceleration())
			uptdatePropellantsTo(acceleration);
		else
			throw new Exception("Acceleration is higher than max acceleration! (" + acceleration + ">"
					+ this.getMaxAceleration() + ")");
		updatetotalAcceleration();
		updateSpeed();
		updateDistance();
		updateGas();
	}

	public int getMaxAceleration() {
		int maxAcc = 0;
		for (Propellant p : propellants)
			if (p.getMaxAcceleration() > maxAcc)
				maxAcc = p.getMaxAcceleration();
		return maxAcc;
	}

	public String toString() {
		return this.name + ":  Distance = " + this.distance + "  ||  Acc= " + this.totalAcceleration + "  ||  Gas= "
				+ this.gasTank.getGas();
	}

	public void stopPropellants() throws Exception {
		for (Propellant p : propellants)
			p.setActualAcceleration(0);
	}

	public void uptdatePropellantsTo(int newAcceleration) throws Exception {
		for (Propellant p : propellants) {
			p.setActualAcceleration(newAcceleration);
		}
	}

	public void reset() throws Exception {
		this.gasTank.setGas(this.gasTank.getTankCapacity());
		this.speed = 0;
		this.totalAcceleration = 0;
		this.distance = 0;
		this.stopPropellants();
	}

}