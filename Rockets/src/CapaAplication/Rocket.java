package CapaAplication;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String name;
	private double speed;
	private double distance;
	private double totalAceleration;
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
		this.totalAceleration = 0;
		this.propellants = new ArrayList<Propellant>();
	}

	public Rocket(String name) throws Exception {
		this.name = name;
		this.gasTank = null;
		this.speed = 0;
		this.distance = 0;
		this.totalAceleration = 0;
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

	public double getTotalAceleration() {
		return this.totalAceleration;
	}

	public void addPropellants(Propellant... propellants) {
		for (Propellant p : propellants)
			this.propellants.add(p);
	}

	public void updateSpeed(int time) {
		this.speed = speed + totalAceleration * 1;
	}

	public void updateTotalAceleration() {
		this.totalAceleration = 0;
		for (Propellant p : propellants)
			this.totalAceleration += p.getActualAcceleration();
	}

	public void updateDistance(int time) {
		this.distance = distance + speed + (1 / 2 * totalAceleration) * Math.pow(time, 2);
	}

	public void updateGas() {
		this.gasTank.setGas(this.gasTank.getGas() - 0.02 * Math.pow(speed, 2));
	}

	public void update(int time) {
		updateTotalAceleration();
		updateSpeed(time);
		updateDistance(time);
		updateGas();
	}

	public double getMaxAceleration() {
		int maxAcc = 0;
		for (Propellant p : propellants)
			if (p.getMaxAcceleration() > maxAcc)
				maxAcc = p.getMaxAcceleration();
		return maxAcc;
	}

	public void determinedAccelerationAlgorihtm(int time, int acceleration) throws Exception {
		if (this.gasTank.getGas() - 0.02 * Math.pow(this.speed + totalAceleration * (time), 2) > 0) {
			// if with the new acceleration the gas will be greater than 0
			if (acceleration <= this.getMaxAceleration())
				updatePropllersTo(acceleration);
			else
				throw new Exception("Acceleration is higher than max acceleration! (" + acceleration + ">"
						+ this.getMaxAceleration() + ")");
		} else {
			stopPropellants(0.0);
		}
		if (this.gasTank.getGas() > 0) {
			update(time);
		}
	}

	public String toString() {
		return this.name + ":  Distance = " + this.distance + "  ||  Acc= " + this.totalAceleration + "  ||  Gas= "
				+ this.gasTank.getGas();
	}

	private void stopPropellants(double multiplier) throws Exception {
		for (Propellant p : propellants)
			p.setActualAcceleration(0);
	}

	private void updatePropllersTo(int newAcceleration) throws Exception {
		for (Propellant p : propellants) {
			p.setActualAcceleration(newAcceleration);
		}
	}
}