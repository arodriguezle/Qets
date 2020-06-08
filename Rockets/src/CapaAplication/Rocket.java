package CapaAplication;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String name;
	private double speed, lastSpeed;
	private double distance, lastDistance;
	private double totalAcceleration, lastTotalAcceleration;
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

	public void addPropellants(Propellant... propellants) {
		for (Propellant p : propellants)
			this.propellants.add(p);
	}

	public void updateSpeed(int time) {
		this.speed = speed + totalAcceleration * 1;
	}

	public void updatetotalAcceleration() {
		this.totalAcceleration = 0;
		for (Propellant p : propellants)
			this.totalAcceleration += p.getActualAcceleration();
	}

	public void updateDistance(int time) {
		this.distance = distance + speed + (1 / 2 * totalAcceleration) * Math.pow(time, 2);
	}

	public void updateGas() {
		this.gasTank.setGas(this.gasTank.getGas() - 0.02 * Math.pow(speed, 2));
	}

	public void update(int time, int acceleration) throws Exception {
		if (acceleration <= this.getMaxAceleration())
			uptdatePropellantsTo(acceleration);
		else
			throw new Exception("Acceleration is higher than max acceleration! (" + acceleration + ">"
					+ this.getMaxAceleration() + ")");
		uptdatePropellantsTo(acceleration);
		updatetotalAcceleration();
		updateSpeed(time);
		updateDistance(time);
		updateGas();
	}

	public void updateBack(int time, int acceleration/* esto creo k sobra */) {
		/*
		 * esto actualiza los valores a los k nuevos lastAtributo quiza con esto
		 * funciona
		 */
	}

	public double getMaxAceleration() {
		int maxAcc = 0;
		for (Propellant p : propellants)
			if (p.getMaxAcceleration() > maxAcc)
				maxAcc = p.getMaxAcceleration();
		return maxAcc;
	}

	public void determinedAccelerationAlgorihtm(int time, int acceleration) throws Exception {
		if (this.gasTank.getGas() - 0.02 * Math.pow(this.speed + totalAcceleration * (time), 2) > 0) {
			// if with the new acceleration the gas will be greater than 0
			if (this.gasTank.getGas() > 0) {
				update(time, acceleration);
			}
		} else {
			stopPropellants(0.0);
		}
	}

	public String toString() {
		return this.name + ":  Distance = " + this.distance + "  ||  Acc= " + this.totalAcceleration + "  ||  Gas= "
				+ this.gasTank.getGas();
	}

	public void stopPropellants(double multiplier) throws Exception {
		for (Propellant p : propellants)
			p.setActualAcceleration(0);
	}

	public void uptdatePropellantsTo(int newAcceleration) throws Exception {
		for (Propellant p : propellants) {
			p.setActualAcceleration(newAcceleration);
		}
	}
}