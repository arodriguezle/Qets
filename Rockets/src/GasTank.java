
public class GasTank {
	private double gas;
	private double tankCapacity;
	
	public GasTank(double tank){
		gas = tank;
		tankCapacity = tank;
	}
	
	public double getGas() {
		return this.gas;
	}
	
	public double getTankCapacity() {
		return this.tankCapacity;
	}
	
	public void updateGas(double speed) {
		this.gas -= 0.02 * Math.pow(speed, 2);
	}
}
