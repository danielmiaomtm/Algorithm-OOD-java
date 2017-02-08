/*范围[1,n]，相加不能重复.
[1, 5]
[1, 1, 4]
[1, 1, 1, 3]
[1, 1, 1, 1, 2]
[1, 1, 1, 1, 1, 1]
[1, 1, 2, 2]
[1, 2, 3]
[2, 4]
[2, 2, 2]
[3, 3]
*/

    public static void main (String[] args) {
	    List<List<Integer>> result = sol.get(6);
	    for (List<Integer> ll : result) {
	    	System.out.println(Arrays.toString(ll.toArray()));
	    }
	    
        
	  }
	

//method 1: the same as fractor combinations		  
	   public List<List<Integer>> getFactors(int n) {
			List<List<Integer>> rs = new ArrayList<>();
			List<Integer> temp = new ArrayList<>();
			helper(rs, temp, n, 1);
			return rs;
		}
		
		public void helper(List<List<Integer>> res, List<Integer> temp, int num, int index) {
			
			for (int i = index; i <= num / 2; i++) {
				if (num - i >= 0 && num - i <= num) {
					temp.add(i);
					temp.add(num - i);
					res.add(new ArrayList<>(temp));
					temp.remove(temp.size() - 1);
					helper(res, temp, num - i, i);
					temp.remove(temp.size() - 1);
				}
			}
		}
	  









// method 2;

	  public static List<List<Integer>> get(int x) {
			List<List<Integer>> rs = new ArrayList<>();
			List<Integer> temp = new ArrayList<>();
			helper(rs, temp, -1, x);
			return rs;
		}
		
		public static void helper(List<List<Integer>> rs, List<Integer> temp, int pos, int x) {
			if (pos != -1) {
				temp.add(x);
				rs.add(new ArrayList<>(temp));
				temp.remove(temp.size() - 1);
			}

			
			for (int i = Math.max(pos, 1); i <= x / 2; i++) {
				temp.add(i);
				//System.out.println("temp: " + temp);
				helper(rs, temp, i, x - i);
				temp.remove(temp.size() - 1);
			}
		}
