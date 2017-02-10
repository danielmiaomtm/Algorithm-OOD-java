import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  private static class Node {
    private double start;
    private double end;
    private double height;
    public Node(double start, double end, double height) {
      this.start = start;
      this.end = end;
      this.height = height;
    }
  }
  
  private List<Node> list;
  private double maxHeight;
  private PriorityQueue<Node> heap;
  
  //constructor 
  public Solution() {
    //sort decendingly by x
    list = new ArrayList<Node>();
    heap = new PriorityQueue<>(11, new Comparator<Node>() {
      public int compare(Node x, Node y) {
        double diff = x.start - y.start;
        if (Math.abs(diff) < 1e-10) {
          return 0;
        }
        return x.start - y.start < 0 ? -1 : 1;
      }
    });
    
    maxHeight = 0;
  }

  public void drop (double x, double height) {
    
    if (heap.isEmpty()) {
      heap.offer(new Node(x, x + height, height));
      maxHeight = height;
      return;
    }
    

    List<Node> nextList = new ArrayList<>();
    
    double curHeight = height;
    double leftBound = x, rightBound = x + height;
    Node leftUncovered = null, rightUncovered = null;
    Boolean firstLeft = true;
    
    
    while (!heap.isEmpty()) {
      
      Node n = heap.poll();
        // if not covered by current range
      
        if (n.end < leftBound || n.start >= rightBound) {
          
          nextList.add(n);
          
        } else {
          
          // add covered area
          //包含关系
          //  1                    2   
          // cur   |_____|         |_________|
          //  n  |__________|    |___|
          
          //不包含
          //  3                    4 
          // cur   |__________|     |_______|
          //  n      |____|            |______|
          
          //   5           
          //   cur      |____|
          //    n |_____|    |____|
          
         
          //left uncovered range
          //1 & 2
          if (firstLeft && n.start < leftBound) {
            leftUncovered = new Node(n.start, leftBound, n.height);
            firstLeft = !firstLeft;
          } else if (firstLeft && leftBound < n.start) {
          //3 & 4
            leftUncovered = new Node(leftBound,n.start, height);
            firstLeft = !firstLeft;
          } 
          
          //right uncovered range
          //1 & 4
         if (n.start < rightBound && rightBound < n.end && n.end > leftBound) {
            rightUncovered = new Node(rightBound, n.end, n.height);
          // 2 & 3 
          } else if (n.start < rightBound && rightBound > n.end && n.end > leftBound) {
            rightUncovered = new Node(n.end, rightBound, height);
          } 

          //   cur       |____|
          //    n |______|    |____|
          
          // update height if there exist covered not hit the the same edge
          if (n.end != leftBound && n.start != rightBound) {
            // update the added cur heights
            curHeight = Math.max(curHeight, height + n.height);
            maxHeight = Math.max(maxHeight, curHeight);
          }
          
          
        }
      
    }
    // add the covered area
    nextList.add(new Node(leftBound, rightBound, curHeight));
    if (leftUncovered != null) {
      nextList.add(leftUncovered);
    }
    if (rightUncovered != null) {
      nextList.add(rightUncovered);
    }
   
    
    // System.out.println("*************");
    for (Node n : nextList) {
        // System.out.println("leftBound   " + leftBound);
        // System.out.println("rightBound  " + rightBound);
      
      //if inside the new range, remove them
      if ((leftBound <= n.start && n.end < rightBound) 
          || (leftBound < n.start && n.end <= rightBound)) {
        //System.out.println("正确的node  " + n.start + " " + n.end + " " + n.height);
      } else {
        // System.out.println("node  " + n.start + " " + n.end + " " + n.height);
        heap.offer(n);
      }
      
    }
        
    
  }
  
   public double getHeight() {
    return maxHeight;
  }
    
    
    
    
 
  public static void main(String[] args) {
    Solution test = new Solution();
    test.drop(0,4);
    System.out.println("maxHeight  " + test.getHeight() + '\n');
    test.drop(4,3);
    System.out.println("maxHeight  " + test.getHeight() + '\n');
    test.drop(3,3);
    System.out.println("maxHeight  " + test.getHeight() + '\n');
    test.drop(-0.5f, 6.5f);
    System.out.println("maxHeight  " + test.getHeight() + '\n');
    test.drop(10, 5);
    System.out.println("maxHeight  " + test.getHeight() + '\n');
    test.drop(5.5f, 3);
    System.out.println("maxHeight  " + test.getHeight() + '\n');
  }
  
  
  
}
