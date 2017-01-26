/*
get a list of conflicting time for meetings, 有点类似leetcode 的meeting rooms, 区别是要列出每个slot里面conflict 的meeting有哪些。
*/

class Node {
  int start;
  int end;
  List<Integer> meetings;
}

int[] meeting = [start, end, id]
public List<Node> conflictingMeetrings (int[][] meetings) {
  
  PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
      public int compare(int[] a, int[] b) { 
      //先把end放前面减去
          if (a[1] == b[1]){
              return b[0] - a[0];
          }
          return a[1] - b[1];
      }
  });

  for (int[] meeting : meetings) {
      heap.offer(new int[]{0, meeting[0], meeting[2]});
      heap.offer(new int[]{1, meeting[1], meeting[2]});
  }
  
  
}





//反过来，[1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
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
