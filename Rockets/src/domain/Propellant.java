package domain;

public class Propellant {

	private int maxAceleration;
	private int actualAceleration;

	public Propellant(int maxAcceleration) {
		this.maxAceleration = maxAcceleration;
		this.actualAceleration = 0;
	}

	public int getMaxAcceleration() {
		return this.maxAceleration;
	}

	public int getActualAcceleration() {
		return this.actualAceleration;
	}

	public void setActualAcceleration(int newAcceleration) throws Exception {
		if (newAcceleration < 0)
			throw new Exception("New Acceleration is lower than 0!");
		else if (newAcceleration <= maxAceleration)
			this.actualAceleration = newAcceleration;
		else
			this.actualAceleration = this.maxAceleration;
	}
}
