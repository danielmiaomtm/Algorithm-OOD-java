class Domino {
	private int left;
	private int right;

	Domino (int left, int right) {
		this.left = left;
		this.right = right;
	}

	public int getLeft () {
		return this.left;
	}
	public int getRight () {
		return this.right;
	}
}

class DominoBag {
	List<Domino> list;
	DominoBag (List<Domino> list) {
		this.list = list;
	}
	public void add (Domino d) {
		list.add(d);
	}
	public void remove(Domino d) {
		list.remove(d);
	}
}

public class practise {
	

	  public static void main (String[] args) {
		  practise sol = new practise();
		  
		  List<Domino> list = new ArrayList<>();
		  list.add(new Domino(1, 3));
		  list.add(new Domino(3, 5));
		  list.add(new Domino(5, 7));
		  list.add(new Domino(2, 3));
		  list.add(new Domino(3, 2));
		  System.out.println(sol.existLoop(list));
	  }
	  
	  // 证明有回路	
  int index = 0;	
  int index = 0;
	  boolean result = false;
	  
	  public boolean existLoop (List<Domino> input) {
			while (index < input.size()) {
				Set<Integer> visited = new HashSet<>();
				existLoopHealper(input, visited, null);
			}
			return result;
		}

		public void existLoopHealper (List<Domino> input, Set<Integer> visited, Domino pre) {
			if (index >= input.size()) {
				return;
			}
			Domino cur = input.get(index);
			
			if (pre != null) {
				if (pre.getRight() != cur.getLeft()) {
					return;
				}
			} 
			if (visited.contains(cur.getRight())) {
				result = true;
				return;
			}
			visited.add(cur.getLeft());
			visited.add(cur.getRight());
			index++;
			existLoopHealper(input, visited, cur);
		}
	  
    
    
    
    
    
    //证明有一个sequence
    public boolean findSequence (List<Domino> input, int start, int end) {
	

	for (int i = 0; i < input.size(); i++) {
		Domino cur = input.get(i);
		if (cur.getRight() == start) {
			//search from here to right
			if (existSubsequence(input, i, end, cur)) {
				return true;
			}
			
		} 
	}
	return false;
}
public boolean existSubsequence (List<Domino> input, int index, int target, Domino pre) {
	if (index >= input.size()) {
		return false;
	}
	boolean result = false;
	Domino cur = input.get(index);

	
		if (cur.getLeft() == target || cur.getRight() == target) {
			return true;
		}

		if (cur.getLeft() != cur.getRight()) {
			return false;
		} else {
			for (int i = index; i < input.size(); i++) {
				result |= existSubsequence(input, i, target, visited, cur);
			}
		}
	
	return result;

	}
}


    
	  
}
