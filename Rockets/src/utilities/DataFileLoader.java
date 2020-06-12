package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.*;

public class DataFileLoader {// lector d'arxius persistens per carregar circuits i cohets.
	private List<Track> tracks;
	private List<Rocket> rockets;
	private File rocketsData, tracksData;
	private static final String rocketsFileName = "rockets.txt", tracksFileName = "tracks.txt";
	private static DataFileLoader instance = null;

	private DataFileLoader() throws Exception {
		this.tracks = new ArrayList<Track>();
		this.rockets = new ArrayList<Rocket>();
		rocketsData = new File(rocketsFileName);
		tracksData = new File(tracksFileName);
	}

	public static DataFileLoader getInstance() throws Exception {
		if (instance == null)
			instance = new DataFileLoader();
		return instance;
	}

	public Track getRandomTrack() throws Exception {
		if (instance == null)
			instance = getInstance();
		if (tracks.size() == 0)
			instance.loadTracks();
		Random rnd = new Random();
		return tracks.get(rnd.nextInt(tracks.size()));
	}

	public List<Rocket> getRockets() throws Exception {
		if (instance == null)
			instance = getInstance();
		if (rockets.size() == 0)
			instance.loadRockets();
		return instance.rockets;
	}

	public void loadRockets() throws Exception {// llegir cohets
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rocketsData), "UTF-8"));
		String st;
		while ((st = br.readLine()) != null) {
			GasTank gasTank = new GasTank(Double.parseDouble(st.split(":")[0].split(";")[1]));
			Rocket dummy = new Rocket(st.split(":")[0].split(";")[0], gasTank);
			dummy.addPropellants(extractPropellants(st.split(":")[1].split(";")));
			this.rockets.add(dummy);
		}
		br.close();
	}

	private List<Propellant> extractPropellants(String[] splitedValues) {
		List<Propellant> propellants = new ArrayList<Propellant>();
		for (int i = 0; i < splitedValues.length; i++) {
			Propellant propellant = new Propellant(Integer.parseInt(splitedValues[i]));
			propellants.add(propellant);
		}
		return propellants;
	}

	public void loadTracks() throws Exception {// llegir circuits
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tracksData), "UTF-8"));
		String st;
		while ((st = br.readLine()) != null) {
			Track dummy = new Track(st.split(";")[0], Double.parseDouble(st.split(";")[1]),
					Integer.parseInt(st.split(";")[2]));
			this.tracks.add(dummy);
		}
		br.close();
	}
}
