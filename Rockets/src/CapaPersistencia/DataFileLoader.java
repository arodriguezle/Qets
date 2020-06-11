package CapaPersistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class DataFileLoader {// lector d'arxius persistens per carregar circuits i cohets.
	private List<Track> tracks;
	private List<Rocket> rockets;
	private File rocketsData, tracksData;
	private static final String rocketsFileName = "rockets.txt", tracksFileName = "tracks.txt";

	public DataFileLoader() {
		this.tracks = new ArrayList<Track>();
		this.rockets = new ArrayList<Rocket>();
		rocketsData = new File(rocketsFileName);
		tracksData = new File(tracksFileName);
	}

	public List<Track> getTracks() throws Exception {
		if (this.tracks.isEmpty() == false)
			return this.tracks;
		else
			throw new Exception("No hi ha circuits carregats!!!");
	}

	public List<Rocket> getRockets() throws Exception {
		if (this.rockets.isEmpty() == false)
			return this.rockets;
		else
			throw new Exception("No hi ha cohets carregats!!!");
	}

	public void loadRockets() throws Exception {// llegir cohets
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rocketsData), "UTF-8"));
		String st;
		int lineCounter = 1;
		Rocket dummy = null;
		String rocketName = "";
		GasTank gasTank = null;
		Propellant propellant;
		while ((st = br.readLine()) != null) {
			if (lineCounter == 1) {
				rocketName = st;
			} else if (lineCounter == 2) {
				gasTank = new GasTank(Double.parseDouble(st));
			} else {
				dummy = new Rocket(rocketName, gasTank);
				if (st.contains(";")) {// varis propulsors
					String[] splitedValues = st.split(";");
					for (int i = 0; i < splitedValues.length; i++) {
						propellant = new Propellant(Integer.parseInt(splitedValues[i]));
						dummy.addPropellants(propellant);
					}
				} else {// un sol propulsor
					propellant = new Propellant(Integer.parseInt(st));
					dummy.addPropellants(propellant);
				}
				lineCounter = 0;
			}
			lineCounter++;
			if (dummy != null) {
				this.rockets.add(dummy);
				dummy = null;
			}

		}
		br.close();
	}

	public void loadTracks() throws Exception {// llegir circuits
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tracksData), "UTF-8"));
		String st;
		int lineCounter = 1;
		Track dummy = null;
		String trackName = "";
		double trackDistance = 0;
		while ((st = br.readLine()) != null) {
			if (lineCounter == 1) {
				trackName = st;
			} else if (lineCounter == 2) {
				trackDistance = Double.parseDouble(st);
			} else {
				dummy = new Track(trackName, trackDistance, Integer.parseInt(st));
				lineCounter = 0;
			}
			lineCounter++;
			if (dummy != null) {
				this.tracks.add(dummy);
				dummy = null;
			}
		}
		br.close();
	}
}
