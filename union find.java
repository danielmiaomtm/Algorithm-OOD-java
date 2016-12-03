/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.


*/

class UnionFind {
    int[] nums;
    UnionFind (int n) {
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
    }
    public void union (int num1, int num2) {
        int n1 = find(num1);
        int n2 = find(num2);
        if (n1 != n2) {
            nums[n1] = n2;
        }
    }
    public int find (int num) {
        if (nums[num] == num) {
            return num;
        }
        nums[num] = find(nums[num]);
        return nums[num];
    }
}
public class Solution {
    public int countComponents(int n, int[][] edges) {
        //union find
        int result = 0;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
       
        for (int i = 0; i < n; i++) {
            uf.find(i);
        }
       
        for (int i = 0; i < n; i++) {
            if (i == uf.nums[i]) {
                result++;
            }
        }
        return result;
    }
}


/*
261. Graph Valid Tree
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
*/


public class Solution {
    int[] nums;
    public boolean validTree(int n, int[][] edges) {
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        for (int[] edge : edges) {
            int n1 = find(edge[0]);
            int n2 = find(edge[1]);
            if (n1 == n2) {
                return false;
            } else {
                nums[n1] = n2;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == nums[i]) {
                count++;
            }
        }
        return count == 1;
    }
    
    public int find (int num) {
        if (nums[num] == num) {
            return num;
        }
        nums[num] = find(nums[num]);
        return nums[num];
    }
}
