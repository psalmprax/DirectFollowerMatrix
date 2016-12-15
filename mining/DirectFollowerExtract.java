package mining;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import model.Event;
import model.Trace;
import utils.parseLine;

public class DirectFollowerExtract {
	//List<List<?>> events1;
    @SuppressWarnings("unused")
	private List<List<StringBuffer>> lists;
    private List<Event> events_s;
	

	public DirectFollowerExtract(String url) throws Exception{
		
		List<String> line = null ;
    	// replace the directory later with url containing the below value
		
        String csvFile = url;
        Scanner scanner = new Scanner(new File(csvFile));
        //events1 = new ArrayList<List<?>>();
        events_s = new ArrayList<Event>();
       int count = 0;
        while (scanner.hasNext()) {
            line = parseLine.parseLiner(scanner.nextLine());
                     
            if(count > 0){
            	
            	DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");
                DateTime dateTime = dateFormat.parseDateTime(line.get(2).substring(0, line.get(2).length()-4));
                try{
                	events_s.add(new Event(line.get(0),line.get(1),dateTime));
                	//events1.add(Event_2.View(Collections.unmodifiableList(line)));
                }catch(java.lang.NullPointerException e){
                	e.printStackTrace();
                }
            }else{
            	System.out.println(line.get(0) + "\t\t\t\t" + line.get(1) + "\t\t\t\t" + line.get(2));
            	 //the first line of the csv file containing the title
            }
            
            count++;
        }
        
        scanner.close();
		 
	}


	public List<Event> getEvents_s() {
		return events_s;
	}
	
	public void display(List<Event> E){
		for(int x = 0; x < E.size(); x++){
			Event event = E.get(x);
			System.out.print(event.getCaseid() + "\t\t");
			System.out.print(event.getActivity() + "\t\t");
			System.out.print(event.getStart() + "\n");
		}
	}
	
	public void displayTraceStat(List<Trace> trace){
		int x,count;
		count = 0;
		Trace event = null;
		for(x = 0; x < trace.size();x++){
			
			event = trace.get(x);
			System.out.print(x + "  ---------------\t");
			if(x < 10){
				System.out.print( event.getTraceId() + "\t\t" );
			}else{
				System.out.print( event.getTraceId() + "\t" );
			}
			
			
			for(int a = 0; a < event.getSeq().size(); a++){
				//System.out.print(event.getSeq().get(a).getActivity() + "\n\t\t\t\t\t");
				//System.out.print(event.getSeq().get(a).getStart() + "\n\t\t\t\t\t");
				count++;
			}
			
			for(int y = 0; y < count; y++){
				System.out.print( "*" );
			}
			
			count = 0;
			
			System.out.print("\n");		
		}
						
	}
	
	public void displayTrace(List<Trace> trace){
		int x;
		Trace event = null;
		for(x = 0; x < trace.size();x++){
			
			event = trace.get(x);
			System.out.print(x + "  ---------------\t");
						
			for(int a = 0; a < event.getSeq().size(); a++){
				
				if(a == 0){
					System.out.print(event.getSeq().get(a).getActivity() + "\t\t\t");
				}else if(event.getSeq().get(a).getActivity().compareTo("Investigation and diagnosis") == 0){
					System.out.print("\t\t\t" + event.getSeq().get(a).getActivity() + "\t\t");	
				}else{
					System.out.print("\t\t\t" + event.getSeq().get(a).getActivity() + "\t\t\t");
				}
				
				System.out.print(event.getSeq().get(a).getStart() + "\t\t\t\t\t\n");
				
			}
		
			System.out.print("\n");		
		}
						
	}
	      	
}


