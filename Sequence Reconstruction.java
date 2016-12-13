/*
Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a 
permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence 
of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether 
there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Example 1:

Input:
org: [1,2,3], seqs: [[1,2],[1,3]]

Output:
false

Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
Example 2:

Input:
org: [1,2,3], seqs: [[1,2]]

Output:
false

Explanation:
The reconstructed sequence can only be [1,2].
Example 3:

Input:
org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

Output:
true

Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
Example 4:

Input:
org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

Output:
true
Show Company Tags
Show Tags
Show Similar Problems

*/

public class Solution {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        //Set to check if all elements are included
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length; i++) {
                map.putIfAbsent(seq[i], new ArrayList<Integer>());
                indegree.putIfAbsent(seq[i], 0);
                if (i > 0) {
                    map.get(seq[i - 1]).add(seq[i]);
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }
        }
        if (org.length != indegree.size()) {
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int key : indegree.keySet()) {
            if(indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                return false;
            }
            int cur = queue.poll();
            
            if (cur != org[index++]) {
                return false;
            }
            
            for (int next : map.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
            
        }
        return index == org.length;
    }
}

