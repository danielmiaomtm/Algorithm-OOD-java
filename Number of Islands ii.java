/*
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 >represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid0 into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid0 into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid1 into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid2 into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

*/


//time: O(Mlog(N)), space: O(N)M表示增加land的数量，N表示矩阵中点的个数即m*n。

//Union Find

public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] id = new int[m * n]; // 表示各个index对应的root
        
        List<Integer> res = new ArrayList<>();
        Arrays.fill(id, -1); // 初始化root为-1，用来标记water, 非-1表示land
        int count = 0; // 记录island的数量
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < positions.length; i++) {
            count++;
            int index = positions[i][0] * n + positions[i][1];           
            id[index] = index; // root初始化
            
            for (int j = 0; j < dirs.length; j++) {
                int x = positions[i][0] + dirs[j][0];
                int y = positions[i][1] + dirs[j][1];
                if (x >= 0 && x < m && y >= 0 && y < n && id[x * n + y] != -1) {
                    int root = find(id, x * n + y);

                    // 发现root不等的情况下，才union, 同时减小count
                    if (root != index) {
                        id[root] = index;
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    
    public int find(int[] id, int i) {
        if (id[i] == i) {
            return i;
        }
        id[i] = find(id[i]);
        return id[i];
    }
}
