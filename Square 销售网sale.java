/*
只做了一道题，首先给一幅有向图，代表销售网，从A指向B就表示A赚到的钱要分一部分给B，分 的percentage就是边的权重。
例如 A -> B, 10% B -> C, 3% A -> C, 4% 就表示A赚到的钱要分10%给B，4%给C，B赚到的钱要分3%给C。
然后再给每个人的销售额，例如 A 1000 要求计算每个人最后剩多少钱，

例如上面的输入，结果应该是 
A 860 (1000 * (1 - 10% - 4%)) 
B 97 (1000 * 10% * (1 - 3%)) 
C 43 (1000 * 4% + 1000 * 10% * 3%

*/



//topological sorting

class Relation {
	  String from;
	  String to;
	  String percentage;
	  Relation (String from, String to, String percentage) {
	    this.from = from;
	    this.to = to;
	    this.percentage = percentage;
	  }
	}

	class Node {
	  String name;
	  int amount;
	  Node (String name, int amount) {
	    this.name = name;
	    this.amount = amount;
	  }
	}
public class practise {
	

	  public static void main (String[] args) {
		practise sol = new practise();
		List<Relation> input = new ArrayList<>();
		input.add(new Relation("A", "B", "5%"));
		input.add(new Relation("C", "E", "4%"));
		input.add(new Relation("B", "F", "2%"));
		input.add(new Relation("E", "F", "4%"));
		
		Map<String, Integer> sales = new HashMap<>();
		sales.put("A", 1000);
		sales.put("C", 1000);
		Map<String, Integer> result = sol.salesTable(input,  sales);
		
 	  }
	  
	  public Map<String, Integer> salesTable (List<Relation> input, Map<String, Integer> sales) {
		    Map<String, Set<String[]>> graph = new HashMap<>();
		    Map<String, Integer> indegree = new HashMap<>();
		    
		    for (Relation sale : input ) {
		    	
		    		graph.put(sale.from, new HashSet<String[]>());;		    			    	
		    		graph.put(sale.to, new HashSet<String[]>());
		    	
		    		indegree.put(sale.from, 0);
		    		indegree.put(sale.to, 0);
		    	
		    	
		    }
		    // store info in two maps
		    for (int i = 0; i < input.size(); i++) {
		    	Relation sale = input.get(i);
		      Set<String[]> set = graph.get(sale.from);
		      boolean isExist = false;
	    	  
		      if (set.size() != 0) {		    	 
		    	  for (String[] cur : set) {
			    	  if (cur[0].equals(sale.to)) {
			    		  isExist = true;
			    	  }
			      }  
		      }		      
		      
		      if (!isExist) {		    	  
		    	  set.add(new String[]{sale.to, sale.percentage});  		    	  
		      }
		      indegree.put(sale.to, indegree.containsKey(sale.to) ? indegree.get(sale.to) + 1 : 1);         
		    }

		    Map<String, Integer> result = sales;
		    
		    //start from the root
		    Queue<String> queue = new LinkedList<>();
		    for (String key : indegree.keySet()) {
		      if (indegree.get(key) == 0) {
		        queue.offer(key);
		      }
		    }
		    	    
		    while (!queue.isEmpty()) {
		      int size = queue.size();
		      for (int i = 0; i < size; i++) {
		        String cur = queue.poll();
		         
		        Set<String[]> nextList = graph.get(cur);
		        if (nextList == null || nextList.size() == 0) {
		          continue;
		        }
		        
		        float curAmount = result.get(cur);
		        float updatedAmount = curAmount;
		        
		        for (String[] saleTo : nextList) {
		          //convert percentage from string to float
		          String percent = saleTo[1];
		          
		          float per = Float.parseFloat((String) percent.subSequence(0, percent.length() - 1)) * 0.01F;
		          
		          updatedAmount -= per * curAmount;
		          //add amount to the payee                             
		          if (!result.containsKey(saleTo[0])) {
		            result.put(saleTo[0], 0);
		          }
		          result.put(saleTo[0], (int)(result.get(saleTo[0]) + curAmount * per));
		         
		          //add next payee to the queue
		          if (indegree.get(saleTo[0]) == 1) {
		              queue.offer(saleTo[0]);
		          }  
		          indegree.put(saleTo[0], indegree.get(saleTo[0]) - 1);
		        
		      }
		        
		        result.put(cur, (int)updatedAmount);
		        
		    }
		    
		  }
		   
		    return result;
	  }
	  
  
}
	
