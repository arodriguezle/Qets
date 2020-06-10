package CapaAplication;

import java.util.ArrayList;

public class Backtracking {
	
	int contSolutions = 0;
	Rocket Qet;
	Track trk;
	Solution sol, millorSol = null;

	public Backtracking(Rocket x, Track y) {
		sol = new Solution();
		Qet = x;
		trk = y;
	}

	public class Solution {
		ArrayList<Integer> acelerationRegister;
		ArrayList<Double> distanceRegister;
		ArrayList<Double> gasRegister;

		public Solution() {
			
			acelerationRegister = new ArrayList<Integer>();
			distanceRegister = new ArrayList<Double>();
			gasRegister = new ArrayList<Double>();
		}

		public String toString() {
			int t = 0;
			String s = "";
			try {
				for (double d : acelerationRegister) {
					s = s + "Second: " + t + " --> Acceleration: " + d + " || Distance: " + Qet.getDistance()
							+ " || Gas: " + Qet.getGas() + "\n";
					t++;
				}
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
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
		if (millorSol.acelerationRegister.size() > sol.acelerationRegister.size()) {
			return true;
		}
		else {
			if (millorSol.acelerationRegister.size() == sol.acelerationRegister.size()) {
				if (millorSol.gasRegister.get(millorSol.gasRegister.size()) < sol.gasRegister.get(sol.gasRegister.size())) {
					return true;
				}
			}
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
		if (contSolutions == 0) {
			for (int t = 0; t <= this.trk.getMaxSeconds(); t++) {
				for (int i = (int)Qet.getMaxAceleration(); i >= 0; i--) {
					if (esAcceptable(i)) {
						Integer valueAcceleration = new Integer(i);
						sol.acelerationRegister.add(valueAcceleration);
						Double valueGas = new Double(Qet.getGas());
						sol.gasRegister.add(valueGas);
						Double valueDistance = new Double(Qet.getDistance());
						sol.distanceRegister.add(valueDistance);
						Qet.update(t, i);
						if (esSolucio()) {
							System.out.println("S'ha trobat una solucio");
							contSolutions = 1;
						} else {
							if (esCompletable()) {
								doBacktracking();
							}
							sol.acelerationRegister.remove(valueAcceleration);
							sol.gasRegister.remove(valueGas);
							sol.distanceRegister.remove(valueDistance);
							Qet.updateBack(sol, t- 1);
						}
					}
				}
			}
		}
	}
}
