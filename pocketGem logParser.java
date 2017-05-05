import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogParser {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "./data/test1.txt";
        if (args.length > 0) {
        	filename = args[0];
        }

        String answer = parseFile(filename);
        System.out.println(answer);
    }

    static String parseFile(String filename)
            throws FileNotFoundException, IOException {
        /*
    	 *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();

        return parseLines(allLines.toArray(new String[allLines.size()]));
    }

    private static Date convertDate(String dateString) {
	    DateFormat df = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
	    Date date = new Date();
	    try {
	      date = df.parse(dateString);
	    } catch (ParseException ignored) {}
	    return date;
	}
    
    static String parseLines(String[] lines) {
    	Map<String, Integer> status = new HashMap<>();
    	status.put("START", 0);
        status.put("CONNECTED", 1);
        status.put("DISCONNECTED", -1);
        status.put("SHUTDOWN", -1);
        List<Date> times = new ArrayList<Date>();
        List<String> events = new ArrayList<String>();
        for (int i = 0; i < lines.length; i++) {
	        String[] line = lines[i].split(" :: ");
	        if(!status.containsKey(line[1])) {
	        	continue;
	        }
	        times.add(convertDate(line[0].substring(1, line[0].length()-1)));
	        events.add(line[1]);
        }
        long totalTime = times.get(times.size()-1).getTime() - times.get(0).getTime();
        long connectedTime = 0;
        long lastTimePoint = 0;
        for (int i=1; i<times.size(); i++) {
        	String currentEvent = events.get(i);
        	long currentTime = times.get(i).getTime();
        	if (status.get(currentEvent) > 0) {
        		lastTimePoint = currentTime;
        	} else if (lastTimePoint > 0) {
	            connectedTime += currentTime - lastTimePoint;
	            lastTimePoint = -1;
        	}
        }
        double ratio = (double) connectedTime / totalTime * 100;
        return String.format("%d%s", (int) ratio, "%");
    }
}
