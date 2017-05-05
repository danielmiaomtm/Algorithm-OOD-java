import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathFinder {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "input_1.txt";
        if (args.length > 0) {
        	filename = args[0];
        }
        
        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }
    
    static List<String> parseFile(String filename)
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

        return parseLines(allLines);    	
    }
    
    static List<String> parseLines(List<String> lines) {
    	Set<String> visited = new HashSet<String>();
    	Map<String, List<String>> graph = new HashMap<String, List<String>>();
    	List<String> res = new ArrayList<String>();
    	String[] ori_des = lines.get(0).split(" ");
    	String start = ori_des[0];
		String end = ori_des[1];
		for(int i = 1; i < lines.size(); i++) {
			String line = lines.get(i);
			String[] node = line.trim().split(":");
			List<String> list = Arrays.asList(node[1].trim().split(" "));
			graph.put(node[0].trim(), list);
		}
		traversal(start, end, "", visited, res, graph);
		return res;
    }
    
    private static void traversal(String start, String end, String path, Set<String> visited, List<String> res, Map<String, List<String>> graph) {
		String curPath = path;
		curPath += start;
		visited.add(start);
		if(start.equals(end)) {
			res.add(curPath);
		} else {
			List<String> adj = graph.get(start);
			if(adj != null) {
				for(String adjNode: adj) {
					if(!visited.contains(adjNode)) {
						traversal(adjNode, end, curPath, visited, res, graph);
					}
				}
			}
		}
		visited.remove(start);
	}
}
