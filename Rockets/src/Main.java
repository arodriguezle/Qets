public class Main {

	public static void main(String[] args) {
		Rocket ViperX = new Rocket("Viper X", 2500.0);
		Propeller propeller1 = new Propeller(50.0), propeller2 = new Propeller(20.0), propeller3 = new Propeller(38.0);
		ViperX.addPropeller(propeller1, propeller2, propeller3);
		Track track = new Track("FreeWorld", 1200.0, 18);
		track.addRocket(ViperX);
		ViperX.printPropieties();

	}
}
