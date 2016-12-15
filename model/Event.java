package model;

import org.joda.time.DateTime;

public class Event {
	private String Caseid;
	private String Activity;
	private DateTime Start;
	//private String Start;
	public Event(String caseid, String activity, DateTime start) {
		this.Caseid = caseid;
		this.Activity = activity;
		
		this.Start = start;
	}
	public String getCaseid() {
		return Caseid;
	}
	public void setCaseid(String caseid) {
		Caseid = caseid;
	}
	public String getActivity() {
		return Activity;
	}
	public void setActivity(String activity) {
		Activity = activity;
	}
	public DateTime getStart() {
		return Start;
	}
	public void setStart(DateTime start) {
		Start = start;
	}

}

