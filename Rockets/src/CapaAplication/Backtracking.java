package CapaAplication;

import java.util.ArrayList;

public class Backtracking {

	Rocket Qet;
	Track trk;
	Solucio sol, millorSol = null;

	public Backtracking(Rocket x, Track y) {
		sol = new Solucio();
		Qet = x;
		trk = y;
	}

	public class Solucio {
		ArrayList<Integer> acelerations;

		public Solucio() {
			acelerations = new ArrayList<Integer>();
		}

		public String toString() {
			int t = 0;
			String s = "";
			for (double d : acelerations) {
				s = s + "Second: " + t + " --> Acceleration: " + d + "\n";
			}
			return "";
		}
	}

	private boolean esSolucio() throws Exception {
		if (Qet.getGas() > 0) {
			if (Qet.getDistance() >= trk.getDistance()) {
				if (trk.getMaxSeconds() >= trk.getSeconds()) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean esMillor() {
		if (millorSol == null) {
			return true;
		}
		if (millorSol.acelerations.size() > sol.acelerations.size()) {
			return true;
		}
		return false;
	}

	private boolean esAcceptable(int i) throws Exception {
		if (Qet.getGas() > 0) {
			if (i < Qet.getMaxAceleration() && i >= 0) {
				return true;
			}
		}
		return false;
	}

	private boolean esCompletable() throws Exception {
		if (Qet.getGas() > 0) {
			if (Qet.getDistance() < trk.getDistance()) {
				return true;
			}
		}
		return false;
	}

	public void doBacktracking() throws Exception {// esto es para un cohete, habria k ponerlo k lo haga en una lista,
													// asi los haria todos a la vez
		for (int t = 0; t <= this.trk.getMaxSeconds(); t++) {
			for (int i = 0; i < Qet.getMaxAceleration(); i++) {
				Integer value = new Integer(i);
				if (esAcceptable(value)) {
					sol.acelerations.add(value);
					Qet.update(i, t);
					if (esSolucio()) {
						System.out.println("S'ha trobat una solucio");
						if (esMillor()) {
							millorSol = sol;
							System.out.println(millorSol.toString());
							Qet.updateBack(i, t);
						}
					} else {
						if (esCompletable()) {
							doBacktracking();
						}
						sol.acelerations.remove(value);
						Qet.updateBack(i, t);
					}
				}
			}
		}
	}
}
