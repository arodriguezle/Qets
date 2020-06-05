package CapaAplication;

public class Propellant {

	private double maxAceleration;
	private double actualAceleration;

	public Propellant(double maxAcceleration) {
		this.maxAceleration = maxAcceleration;
		this.actualAceleration = maxAcceleration;
	}

	public double getMaxAcceleration() {
		return this.maxAceleration;
	}

	public double getActualAcceleration() {
		return this.actualAceleration;
	}

	public void setActualAcceleration(double newAcceleration) throws Exception {
		if (newAcceleration <= maxAceleration)
			this.actualAceleration = newAcceleration;
		else
			throw new Exception("New Acceleration is higher than Max Acceleration!");
	}
}
