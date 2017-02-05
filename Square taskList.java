
//https://docs.google.com/document/d/1WVEY8ukZFRpyWQf0p0nNMiWp9n-olLFTPASd8TTe_R4/pub
public class practise {
	
	  static Map<String, Set<String>> graph;
	  static Map<String, Integer> indegree;
	    
	  public static void addTask (String task) {
		  
		  if (!graph.containsKey(task)) {
			  Set<String> set = new HashSet<>();
			  graph.put(task, set);
		  }
		  if (!indegree.containsKey(task)) {
			  indegree.put(task, 0);
		  }
	   
	  }
	  
	  practise () {
		  this.graph = new HashMap<>();
		  this.indegree = new HashMap<>();
	  }
	  public static void addDep(String before, String after) {
	  // before -> after
	    graph.get(before).add(after);
	    indegree.put(after, indegree.get(after) + 1);
	  }
	  
	  public static void print() {

		Map<String, Set<String>> graphCopy = new HashMap<>();
		graphCopy.putAll(graph);
		Map<String, Integer> indegreeCopy = new HashMap<>();
		indegreeCopy.putAll(indegree);
	    List<String> result = new ArrayList<>();	    
	    List<String> next = findAllNextCandidates();
	    
	  	while (next.size() > 0) {
			    
	      List<String> nextTemp = new ArrayList<>();
	      
	      for (int i = 0; i < next.size(); i++) {
	    	
	        String cur = next.get(i);
	        result.add(cur);
	        for (String nexttask : graphCopy.get(cur)) {
	        	indegreeCopy.put(nexttask, indegreeCopy.get(nexttask) - 1);
		        if (indegreeCopy.get(nexttask) == 0) {
		          nextTemp.add(nexttask);
		        }		        
	        }
	        
	      }	      
	      next = nextTemp;	    
	    }
	    
	    for (String str : result) {
	      System.out.println(str);
	    }

	  }
	  
	  
	  public static boolean isNextCandidate(String task) {  

	    for (String key : indegree.keySet()) {
	      if (indegree.get(key) == 0 && key.equals(task)) {
	        return true;
	      }
	    }
	    return false;
	    
	  }
	  
	  
	  public static List<String> findAllNextCandidates() {
		  
		  Map<String, Set<String>> graphCopy = graph;
		  Map<String, Integer> indegreeCopy = indegree;
			
	    List<String> result = new ArrayList<>();
	    if (indegree.size() == 0) {
	      return result;
	    }
	    
	    for (String key : indegreeCopy.keySet()) {
	    	
	      if (indegreeCopy.get(key) == 0) {
	        result.add(key);
	      }
	      
	    }

	    return result;
	  }
	  
	  
	  
	  public static String popNext() {

	    List<String> nexts = findAllNextCandidates();

	    if (nexts.size() == 0) {
	      return null;
	    }
	    
	    String result = nexts.get(nexts.size() - 1);
	    //update indegree map
	    for (String next : graph.get(result)) {
	      indegree.put(next, indegree.get(next) - 1);
	    }
	    //update graph map
	    graph.remove(result);
	    indegree.remove(result);
	    
	    return result;
	  }
	  
	  
	  
	  public static void main (String[] args) {
		practise tasklist = new practise();
	    addTask("rent car");
	    addTask("buy wine");
	    addTask("buy dessert");
	    addTask("drive to mv");
	    addDep("rent car", "buy wine");
	    addDep("rent car", "buy dessert");
	    addDep("buy wine", "drive to mv");
	    addDep("buy dessert", "drive to mv");
	    print();

	    System.out.println("下面call popNext，里面被修改");
	    String pop = popNext();
	    System.out.println("pop出来的是   " + pop);
	    System.out.println("**********");
	    print();
	  }
	  


}
