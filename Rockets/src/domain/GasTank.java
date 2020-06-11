package domain;

public class GasTank {
	private double currentGas;
	private double maxTankCapacity;

	public GasTank(double tank) throws Exception {
		if (tank >= 0) {
			currentGas = tank;
			maxTankCapacity = tank;
		} else
			throw new Exception("Tank capacity is lower than 0!");
	}

	public double getGas() {
		return this.currentGas;
	}

	public double getTankCapacity() {
		return this.maxTankCapacity;
	}

	public void updateGas(double speed) throws Exception {
		if (speed >= 0)
			this.currentGas -= 0.02 * Math.pow(speed, 2);
		else
			throw new Exception("Rockets can't go backwards!");
	}

	public void setGas(double gas) throws Exception {
		if (gas <= this.maxTankCapacity) {
			if(gas < 0) {
				this.currentGas = 0;
			}
			this.currentGas = gas;
		}else throw new Exception("Gas setted is higher than MaxCapacity!");
	}
}
