package application;

import java.util.List;

import domain.Track;
import domain.Record;
import utilities.DataFileLoader;
import utilities.RecordRepository;

public class Controller {
	private static Track track;
	private static DataFileLoader dfl;

	public Controller() throws Exception {
		dfl = DataFileLoader.getInstance();
	}

	public void startRace() throws Exception {
		track.startRace();
	}

	public void initiateTrack() throws Exception {
		track = TrackFactory.getTrack(dfl);
	}

	public void initiateRockets() throws Exception {
		track.addRockets(RocketFactory.getRockets(dfl));
	}

	public List<String> getResults() throws Exception {
		return track.getResults();
	}

	public Track getTrack() {
		return track;
	}

	public void saveNewRecord() {
		if (track.getBestTime() < RecordRepository.getRecord(track.getName())) {
			Record newRecord = new domain.Record(track.getName(), track.getWinner().getName(), track.getBestTime());
			RecordRepository.storeRecord(newRecord);
		}
	}
}
