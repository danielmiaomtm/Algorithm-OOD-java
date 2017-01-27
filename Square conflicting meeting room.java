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


