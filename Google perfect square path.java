	  /*
    input    13       10
    output: [2,3]    [3, 1]
    */
    
    public List<Integer> minSquare (int target) {
		    int[] arrs = new int[target + 1];
			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i <= target; i++) {
				List<Integer> temp = new ArrayList<>();
				result.add(temp);
			}
			int minLen = Integer.MAX_VALUE;
			int index = -1;
			
			for (int i = 1; i <= target; i++) {
				arrs[i] = Integer.MAX_VALUE;
				for (int j = 1; j <= target; j++) {
					if (i - j * j >= 0 && arrs[i - j * j] != Integer.MAX_VALUE) {
						if (arrs[i - j * j] + 1 < arrs[i]) {
							arrs[i] = arrs[i - j * j] + 1;
							
							List<Integer> list = result.get(i - j * j);
							
							List<Integer> temp = new ArrayList<>();
							temp.addAll(list);
							temp.add(j);
							
							result.set(i, temp);
						}
						
					}
				}
				if (arrs[i] < minLen) {
					index = i;
				}
			}

			return result.get(index);
		}
