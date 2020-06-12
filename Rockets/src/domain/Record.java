package domain;

public class Record {
	String trackName;
	String rocketName;
	int time;
	
	public Record() {
		
	}
	
	public Record(String t, String r, int time) {
		this.trackName = t;
		this.rocketName = r;
		this.time = time;
	}
}
