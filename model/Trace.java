package model;

import java.util.List;

public class Trace {
	private String traceId;
	private List<Event> Seq;
	public Trace(String traceId,List<Event> Seq){
		this.traceId = traceId;
		this.Seq = Seq;
		
	 }
	public String getTraceId() {
		return traceId;
	}
	public List<Event> getSeq() {
		return Seq;
	}
}
