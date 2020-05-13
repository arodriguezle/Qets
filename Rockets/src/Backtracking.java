import java.util.ArrayList;

public class Backtracking {
	
	Rocket Qet;
	Track trk;
	Solucio sol, millorSol=null;
	
	public Backtracking(Rocket x, Track y) {
		sol = new Solucio();
		Qet = x;
		trk = y;
	}
	
	private class Solucio {
		ArrayList<Double> acelerations;
		public Solucio(){
			acelerations = new ArrayList<Double>();
		}
		public String toString() {
			int t = 0;
			String s = "";
			for (double d : acelerations) {
				s = s + "Second: " + t +" --> Acceleration: " + d + "\n";
			}
			return "";
		}
	}
	
	private boolean esSolucio() {
		if (Qet.getGas()>0) {
			if (Qet.getDistance()>=trk.getDistance()) {
				if (trk.getMaxSeconds()>=trk.getSeconds()){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean esMillor() {
		if (millorSol==null) {
			return true;
		}
		if (millorSol.acelerations.size()>sol.acelerations.size()) {
			return true;
		}
		return false;
	}
	
	private boolean esAcceptable() {
		// queda gas, aceleration nueva < max aceleration nueva > 0
		return false;
	}
}
