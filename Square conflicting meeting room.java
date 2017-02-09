/*
get a list of conflicting time for meetings, 有点类似leetcode 的meeting rooms, 区别是要列出每个slot里面conflict 的meeting有哪些。
存开始和结束两点的信息，然后遇见starttime存，endtime删，如果list.size() >= 2，就有conlicts，加入，同时用一个pos来记录位置和list来记录meeting.
*/

import java.io.*;
import java.util.*;

class conflicts {
  int start;
  int end;
  List<Node> meetings;
  conflicts (int start, int end, List<Node> meetings) {
    this.start = start;
    this.end = end;
    this.meetings = meetings;
  }
}
// every node point record start and end time point 
class Node {
  // pos : 0 means left; 1 means right
  int pos;
  int time;
  int name;
  Node (int pos, int time, int name) {
    this.pos = pos;
    this.time = time;
    this.name = name;
  }
}

class Solution {
 
  //int[] meeting = [start, end, id];
    
  public List<conflicts> conflictingMeetrings (int[][] input) {

    PriorityQueue<Node> heap = new PriorityQueue<>(11, new Comparator<Node>() {
        public int compare(Node a, Node b) { 
        //先把end放前面，先减去，再加入
            if (a.time == b.time){
                return b.pos - a.pos;
            }
            return a.time - b.time;
        }
    });
        
    for (int[] meeting : input) {
      heap.offer(new Node(0, meeting[0], meeting[2]));
      heap.offer(new Node(1, meeting[1], meeting[2]));
    }
    
    List<conflicts> result = new ArrayList<>();
  
    // conflicts list
    List<Node> list = new ArrayList<>();
    // position record
    int lastPos = -1;
    //List<Integer> pos = new ArrayList<>();
    
    
    while (!heap.isEmpty()) {

      Node cur = heap.poll();
      // if it is a start time pos
      if (cur.pos == 0) {
        // if there is more than 1 meetings get the conflicts
        if (list.size() >= 2) {
          result.add(new conflicts(lastPos, cur.time, new ArrayList<>(list)));
        }
        
        list.add(cur);
        
      } else {
        // if it is a end time pos
        if (list.size() >= 2) {
          result.add(new conflicts(lastPos, cur.time, new ArrayList<>(list)));
        }
        
        // since it meets endTime, remove the meetings in list
        Iterator<Node> ite = list.iterator();
        while (ite.hasNext()) {
          if (ite.next().name == cur.name) {
            ite.remove();
          }
        }
                
      }
      lastPos = cur.time;
      //pos.add(cur.time);
          
    }
    return result;
    
    
  }
 
  public static void main(String[] args) {
    Solution test = new Solution();
    int[][] meetings = new int[][]{{1,5,0}, {2,8,1}, {3,6,2}, {8, 10, 3}};
    List<conflicts> conf = test.conflictingMeetrings(meetings);
    
    //System.out.println(conf.size());
    
    for (conflicts con : conf) {
      System.out.println("start at " + con.start + "  end at " + con.end);
      System.out.println("conflicts with meetings :  ");
      List<Node> list = con.meetings;
      for (Node n : list) {
        System.out.println(n.name);
      }
    }
  
  }
  
  
  
}



