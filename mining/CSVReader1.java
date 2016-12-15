package mining;

import java.util.LinkedList;
import java.util.List;

import model.Event;
import model.Trace;
import utils.Utils;

public class CSVReader1 {
	public static void main(String[] args){
			
			try {
				DirectFollowerExtract file = new DirectFollowerExtract("C:/Users/Cpluslus/workspace/Model/src/Mining/IncidentExample.csv");
				List<Event> reciever = file.getEvents_s();
				file.display(reciever);
				
				LinkedList<Trace> trace = new LinkedList<Trace>();
				//trace.addAll(Collections.unmodifiableList(reciever));
				trace.addAll(Utils.retSeq(reciever));
				
				if(!trace.isEmpty()){
					file.displayTrace(trace);
					file.displayTraceStat(trace);
				}
								
			}catch (Exception e) {
				e.printStackTrace();
			}
			
	}
		
}
