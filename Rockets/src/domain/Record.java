package domain;

public class Record {
	private String trackName;
	private String rocketName;
	private int time;

	public Record() {

	}

	public Record(String trackName, String rocketName, int time) {
		this.trackName = trackName;
		this.rocketName = rocketName;
		this.time = time;
	}

	public int getTime() {
		return this.time;
	}

	public String getRocketName() {
		return this.rocketName;
	}

	public String getTrackName() {
		return this.trackName;
	}
}
