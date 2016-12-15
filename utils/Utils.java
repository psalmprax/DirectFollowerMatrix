package utils;

import java.util.LinkedList;
import java.util.List;

import model.Event;
import model.Trace;

public class Utils {
	private static Trace trace;
	private static LinkedList<Event> seq;
	private static LinkedList<Trace> traces;
	
	public static List<Trace> retSeq(List<Event> Eve){
		seq = new LinkedList<Event>();
		traces = new LinkedList<Trace>();
		
		try{
			Event event = new Event(Eve.get(0).getCaseid(),Eve.get(0).getActivity(),Eve.get(0).getStart());
			//Event event3 = null;	
			for(int x = 0; x < Eve.size(); x++){
				Event event2 = new Event(Eve.get(x).getCaseid(),Eve.get(x).getActivity(),Eve.get(x).getStart());
										
				if(event.getCaseid().compareTo(event2.getCaseid()) != 0){
					trace = new Trace(event.getCaseid(),seq);
					traces.add(trace);
					event = event2;
					seq =  new LinkedList<Event>();
					seq.add(event2);
					
				}
				else {
					if(x<=Eve.size()){
						
						seq.add(event2);
						
						if( x+1 == Eve.size()){
							trace = new Trace(event.getCaseid(),seq);
							traces.add(trace);
						}
												
					}
				}
							
			}
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		return traces;
	}

}
