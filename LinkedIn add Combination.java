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
