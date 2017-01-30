/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

*/

//iteration
public int depthSum(List<NestedInteger> nestedList) {
    int sum=0;
 
    LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>();
    LinkedList<Integer> depth = new LinkedList<Integer>();
 
    for(NestedInteger ni: nestedList){
        queue.offer(ni);
        depth.offer(1);
    }
 
    while(!queue.isEmpty()){
        NestedInteger top = queue.poll();
        int dep = depth.poll();
 
        if(top.isInteger()){
            sum += dep*top.getInteger();
        }else{
            for(NestedInteger ni: top.getList()){
                queue.offer(ni);
                depth.offer(dep+1);
            }
        }
    }
 
    return sum;
}


//recursion
public int depthSum(List<NestedInteger> nestedList) {
	if (nestedList == null || nestedList.size() == 0) {
	    return 0;
	}
	return helper(nestedList, 1);
	}
	public int helper (List<NestedInteger> nestedList, int depth) {

	int result = 0;
	for (NestedInteger n : nestedList) {
	    if (n.isInteger()) {
		result += n.getInteger() * depth;
	    } else {
		result += helper(n.getList(), depth + 1);
	    }
	}
	return result;
}




/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
*/

public int depthSumInverse(List<NestedInteger> nestedList) {
	Map<Integer, Integer> map = new HashMap<>();
	helper(nestedList, depth, map);
	
	int result = 0;
	int maxDepth = Integer.MIN_VALUE;
	for (int n : map.keSet()) {
		maxDepth = Math.max(maxDepth, n);
	}

	for (int n : map.keySet()) {
		result += (maxDepth - n + 1) * map.get(n);
	}
	
	return result;

}
public void helper (List<NestedInteger> nestedList, int depth, Map<Integer, Integer> map) {
	
	for (NestedInteger n : nestedList) {
		if (n.isInteger()) {
			Integer num = map.get(n);
			if (num == null) {
				map.put(depth, n.getInteger());
			} else {
				map.put(depth, map.get(depth) + n.getInteger());
			}
		} else {
			helper(n.getList(), depth + 1);
		}
	}
	return max;
}





// much simpler version
public int depthSumInverse(List<NestedInteger> nestedList) {
         
         if (nestedList == null || nestedList.size() == 0) {
             return 0;
         }
         int sum = 0;
         
         int unweightedSum = 0, weightedSum = 0;
        
         while (!nestedList.isEmpty()) {
            List<NestedInteger> nextList = new ArrayList<>();
             for (NestedInteger nest : nestedList) {
                 if (nest.isInteger()) {
                    unweightedSum += nest.getInteger();        
                 } else {
                    nextList.addAll(nest.getList());
                 }
             }
             weightedSum += unweightedSum;
             nestedList = nextList;
         }
         return weightedSum;
}

