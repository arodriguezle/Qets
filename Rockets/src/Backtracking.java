import java.util.ArrayList;

public class Backtracking {
	
	Rocket Qet;
	Track trk;
	Solucio sol;
	
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
			if (Qet.getDistance()==trk.getDistance()) {
				return true;
			}
		}
		return false;
	}
}
