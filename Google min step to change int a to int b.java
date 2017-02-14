/*
  给两个数，a和b,保证a < b. 问最少需要几步edit能把a变成b。 
  其中合法的Edit包括＋1， －1， ＊2.


  input (4, 22)
  
  [+1, *2, +1, *2] minStep: 4
*/

public class practise {
	

	  public static void main (String[] args) {
		  practise sol = new practise();
  
		  List<List<String>> temp = sol.editStop(4, 22);
		  for (List<String> ll : temp)
			  System.out.println(Arrays.toString(ll.toArray()));
		  		  
	  }
	  
	  
	  int minStep = Integer.MAX_VALUE;
	  public List<List<String>> editStop (int a, int b) {
		  List<List<String>> result = new ArrayList<>();
		  List<String> list = new ArrayList<>();
	  	  helper(a, b, 0, 0, list, result);
	  	return result;
	  }
	  // index [+1, -1, *2]
	  public void helper (int input, int target, int step, int index, List<String> list, List<List<String>> result) {
		  if (step > minStep) {
			  return;
		  }
	  	if (input < 0 || input > target) {
	  		return;
	  	}
	  	if (input == target) {
	  		if (step < minStep) {
	  			minStep = step;
	  			if (result.size() == 0) {
	  				result.add(new ArrayList<>(list));
	  			} else {
	  				result.set(0, new ArrayList<>(list));
	  			}
	  		}	  		
	  		return;
	  	}
	  	for (int i = index; i < 3; i++) {
	  		if (i == 0) {
	  			list.add("+1");
	  			helper(input + 1, target, step + 1, index, list, result);
	  			list.remove(list.size() - 1);
	  		} else if (i == 1) {
	  			list.add("-1");
	  			helper(input - 1, target, step + 1, index, list, result);
	  			list.remove(list.size() - 1);
	  		} else {
	  			list.add("*2");
	  			helper(input * 2, target, step + 1, index, list, result);
	  			list.remove(list.size() - 1);
	  		}
	  	}
	  }

	  
	  
}
