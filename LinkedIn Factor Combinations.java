/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
*/


public class Solution {
    public List<List<Integer>> getFactors(int n) {
         List<List<Integer>> result = new ArrayList<List<Integer>>();
         if (n <= 1) {
             return result;
         }
         result.add(new ArrayList<>(Arrays.asList(1, n)));
         List<Integer> list = new ArrayList<>();
         helper(result, list, n, 2);
         return result;
    }
    public void helper (List<List<Integer>> result, List<Integer> list, int n, int index) {
        
        for (int i = index; i <= (int)Math.sqrt(n) ; i++) {
            if (n % i == 0 && n / i >= i) {
                list.add(i);
                list.add(n / i);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                helper(result, list, n / i, i);
                list.remove(list.size() - 1);
            }
        }
        
    }
}




/*
Print all unique combinations of factors of a positive integer. For example given 24:

24*1
12*2
8*3
6*4
6*2*2
4*3*2
3*2*2*2
*/

public List<List<Integer>> factorCombinations(int n) {
	    List<List<Integer>> ans = new ArrayList<List<Integer>>();
	    helper(ans, n, n / 2, new ArrayList<Integer>());
	    return ans;
	}

	private void helper(List<List<Integer>> ans, int num, int largestFactor,
	        List<Integer> path) {
	    if (num == 1) {
	        ans.add(new ArrayList<Integer>(path));
	        return;
	    }
	    for (int i = largestFactor; i > 1; i--) {
	        if (num % i == 0) {
	            path.add(i);
	            helper(ans, num / i, i, path);
	            path.remove(path.size() - 1);
	        }
	    }
	}
}
