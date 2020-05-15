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
		ArrayList<Integer> acelerations;
		public Solucio(){
			acelerations = new ArrayList<Integer>();
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
	
	private boolean esAcceptable(int i) {
		if (Qet.getGas()>0) {
			if(i < Qet.getMaxAceleration()  && i > 0) {
				return true;
			}
		}
		return false;
	}
	
	private boolean esCompletable() {
		if(Qet.getGas()>0) {
			if(Qet.getDistance()<trk.getDistance()) {
				return true;
			}
		}
		return false;
	}
	
	public void Backtracking() {
		for(int i=1; i<Qet.getMaxAceleration(); i++) {
			Integer value = new Integer(i);
			if (esAcceptable(value)){
				sol.acelerations.add(value);
				if(esSolucio()) {
					System.out.println("S'ha trobat una solucio");
					if (esMillor()) {
						millorSol = sol;
						System.out.println(millorSol.toString());
					}
					sol.acelerations.remove(value);
				}
				else {
					if (esCompletable()) {
						Backtracking();
					}
					sol.acelerations.remove(value);
				}
			}
		}
	}
}
