/*

A:-3
B:-1
C:4

C gives 3 to A
C gives 1 to B

*/

class Transaction {
	String payer;
	List<String> payee;
	int amount;
	Transaction (String payer, List<String> payee, int amount) {
		this.payer = payer;
		this.payee = payee;
		this.amount = amount;
	}
}
public static void main (String[] args) {
  
    List<Transaction> input = new ArrayList<>();
		 List<String> names = new ArrayList<>(Arrays.asList("A", "B", "C"));
		 input.add(new Transaction("A", names, 12));
		 names = new ArrayList<>(Arrays.asList("A", "B"));
		 input.add(new Transaction("B", names, 10));
		 
		 List<Balance> result = sol.printBalance(input);
		 
		 for (Balance b : result) {
			 System.out.println(b.name + ":" + b.amount);
		 }
     
}


public List<Balance> printBalance (List<Transaction> input) {
		// store <name, balanced amount>  
		List<Balance> result = new ArrayList<>();
	
		Map<String, Integer> map = new HashMap<>();
	
		for (Transaction t : input) {
			String payer = t.payer;
			List<String> payee = t.payee;
			//
			int perPerson = t.amount / payee.size();
			// store all the people into map
			if (!map.containsKey(payer)) {
				map.put(payer, 0);
			} 
			
			for (String name : payee) {
				if (!map.containsKey(name)) {
					map.put(name, 0);
				} 
				if (!name.equals(payer)) {
					map.put(name, map.get(name) + perPerson);
				} else {
					map.put(name, map.get(name) - perPerson * (payee.size() - 1));
				}
			}
		}
		
		//print all the balance
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			Balance b = new Balance(entry.getKey(), entry.getValue());
			result.add(b);
		}
		return result;
	}
  
  
  
  
  
 public void printReturn (List<Balance> input) {
		Deque<Balance> negative = new LinkedList<>();
		Deque<Balance> positive = new LinkedList<>();
		
		for (Balance b : input) {
			if (b.amount < 0) {
				negative.offer(b);
			} else if (b.amount > 0) {
				positive.offer(b);
			}
		}
		
		
		while (!negative.isEmpty() || !positive.isEmpty()) {
			Balance n = negative.pollFirst();
			Balance p = positive.pollFirst();
			
			int amount = n.amount + p.amount;
			
			if (amount < 0) {
				negative.offerFirst(new Balance(n.name, amount));
				System.out.println(p.name + " gives " + p.amount + " to " + n.name);
			} else if (amount > 0) {
				positive.offerFirst(new Balance(p.name, amount));
				System.out.println(p.name + " gives " + n.amount * -1 + " to " + n.name);
			}else {
				System.out.println(p.name + " gives " + n.amount * -1 + " to " + n.name);
			}
		}
		
	}
  
