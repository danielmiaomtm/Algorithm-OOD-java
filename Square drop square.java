/*
就是实现drop(double x, double size) 和getHeight(double x)
*/


import java.io.*;
import java.util.*;

class Solution {
  //private class to protect the parameter 
  private static class Node {
    private float a;
    private float b;
    private float h;
    public Node(float a, float b, float h) {
      this.a = a;
      this.b = b;
      this.h = h;
    }
  }
  
  private TreeSet<Node> treeset;
  private float maxHeight;
  
  //constructor 
  public Solution() {
    //sort decendingly by x
    treeset = new TreeSet<Node>(new Comparator<Node>() {
      public int compare(Node x, Node y) {
        float diff = x.a - y.a;
        if (Math.abs(diff) < 1e-10) {
          return 0;
        }
        return x.a < y.a ? -1 : 1;
      }
    });
    maxHeight = 0;
  }

  public void drop(float position, float size) {
    Node newnode = new Node(position, position + size, size);
    
    Node left = getLeftBound(newnode);
    Node right = getRightBound(newnode);
    
    if (left == null && right == null) {
      treeset.add(newnode);
      maxHeight = Math.max(maxHeight, size);
      return;
    }
    //update curMaxHeight between leftBound and rightBound
    float curMaxHeight = left.h;
    Node cur = left;
    while (cur != right) {
      Node tmp = treeset.higher(cur);
      curMaxHeight = Math.max(curMaxHeight, cur.h);
      treeset.remove(cur);
      cur = tmp;
    }
    curMaxHeight = Math.max(curMaxHeight, right.h);
    treeset.remove(right);
    //update the treeset 
    // reserve the uncovered leftBound and rightBound height
    if (left.a < newnode.a) { 
      treeset.add(new Node(left.a, newnode.a, left.h));
    }
    if (newnode.b < right.b) {
      treeset.add(new Node(newnode.b, right.b, right.h));
    }
    //update the new coverd area
    treeset.add(new Node(newnode.a, newnode.b, size + curMaxHeight));
    
    //update the maxHeight
    maxHeight = Math.max(maxHeight, size + curMaxHeight);
  }
  
  private Node getLeftBound(Node n) {
    Node smaller = treeset.lower(n);
    
    if (smaller != null && overlap(smaller, n)) {
      return smaller;
    }
    
    Node larger = treeset.ceiling(n);
    if (larger != null && overlap(larger, n)) {
      return larger;
    }
    
    return null;
  }

  private Node getRightBound(Node n) {
    Node dummy = new Node(n.b, n.b, n.h);
    Node smaller = treeset.floor(dummy);
    if (smaller != null && overlap(smaller, n)) {
      return smaller;
    }
    return null;
  }

  private boolean overlap(Node x, Node y) {
    // [x.a  x.b]   [y.a  y.b]
    // [y.a  y.b]   [x.a  x.b]
    //greater
    return !(y.a - x.b > 1e-10) && !(x.a - y.b > 1e-10) && !(x.b == y.a) && !(y.b == x.a);;
    
  }

  
   public float getHeight() {
    return maxHeight;
  }
  
  public static void main(String[] args) {
    Solution test = new Solution();
    test.drop(1,4);
    System.out.println(test.getHeight());
    test.drop(-1,2);
    System.out.println(test.getHeight());
    test.drop(-1,3);
    System.out.println(test.getHeight());
    test.drop(5.5f, 3);
    System.out.println(test.getHeight());
    test.drop(10, 5);
    System.out.println(test.getHeight());
    test.drop(-1, 6.5f);
    System.out.println(test.getHeight());
  }
  
  
  
}
