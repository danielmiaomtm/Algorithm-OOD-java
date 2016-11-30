/*
We can use Best First Search algorithm to solve this problem, 
the key idea is how to manage the states and how to generate new states. Let's say we have the following input (sorted) arrays:

x[] = {1, 2, 4, 6}

y[] = {2, 3, 5, 8, 10}

The initial state contains x[0] and y[0], the sum is 3 which is the minimum sum (of course), as we know, in order to quickly 
know which state has the minimum sum, we can use a min heap to manage the states, so let's add the initial state to the min heap, 
now we complete the first step in Best First Search.

How to generate new states? It's simple, each state knows the current index of x[] (i) and y[] (j), we just need to put (x[i], y[j+1]) 
and (x[i+1], y[j]) to the min heap and let it figure out what will be the next state.

Best First Search algorithm is pretty useful in solving problems like finding k-th element from bunch of sorted input data. Below is 
the Java solution for this problem, we assume that k is 1-based and within a valid range.

Time complexity is O(klog(k)).
*/

public class Solution {
  
  class State {
    int i;   // index of x[]
    int j;   // index of y[]
    int sum; // x[i] + y[j]
    
    public State(int i, int j, int sum) {
      this.i = i;
      this.j = j;
      this.sum = sum;
    }
  }
  
  public int findKthDistinctSum(int[] x, int[] y, int k) {
    if (x.length == 0 || y.length == 0) {
      throw new IllegalArgumentException("Can't handle zero-length arrays.");
    }
    
    // use a min heap to poll the next state that has minimum sum
    PriorityQueue<State> heap = new PriorityQueue<>(new Comparator<State>() {
      public int compare(State a, State b) {
        return a.sum - b.sum;
      }
    });
    
    // use a hash set to avoid duplicate sum
    Set<Integer> set = new HashSet<>();
    
    // step 1. create initial state
    int sum = x[0] + y[0];
    heap.offer(new State(0, 0, sum));
    set.add(sum);
    
    // step 2. generate new states based on current state
    // until we get the kth smallest sum
    while (k > 1) {
      State s = heap.poll();
      
      // new state 1: x[i], y[j + 1]
      if (s.j < y.length - 1) {
        sum = x[s.i] + y[s.j + 1];
        
        if (!set.contains(sum)) {
          heap.offer(new State(s.i, s.j + 1, sum));
          set.add(sum);
        }
      }
      
      // new state 2: x[i + 1], y[j]
      if (s.i < x.length - 1) {
        sum = x[s.i + 1] + y[s.j];
        
        if (!set.contains(sum)) {
          heap.offer(new State(s.i + 1, s.j, sum));
          set.add(sum);
        }
      }
      k--;
    }
    
    return heap.poll().sum;
  }
  
}
