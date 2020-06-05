package CapaAplication;

public class GasTank {
	private double gas;
	private double tankCapacity;

	public GasTank(double tank) throws Exception {
		if (tank >= 0) {
			gas = tank;
			tankCapacity = tank;
		} else
			throw new Exception("Tank capacity is lower than 0!");
	}

	public double getGas() {
		return this.gas;
	}

	public double getTankCapacity() {
		return this.tankCapacity;
	}

	public void updateGas(double speed) throws Exception {
		if (speed >= 0)
			this.gas -= 0.02 * Math.pow(speed, 2);
		else
			throw new Exception("Rockets can't go backwards!");
	}

	public void setGas(double gas) {
		this.gas = gas;
	}
}
