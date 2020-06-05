package CapaAplication;
public class Propeller {

	private double maxAceleration;
	private double actualAceleration;

	public Propeller(double maxAcceleration) {
		this.maxAceleration = maxAcceleration;
		this.actualAceleration = maxAcceleration;
	}

	public double getMaxAcceleration() {
		return this.maxAceleration;
	}

	public double getActualAcceleration() {
		return this.actualAceleration;
	}

	public void setActualAcceleration(double newAcceleration) {
		this.actualAceleration = newAcceleration;
	}
}