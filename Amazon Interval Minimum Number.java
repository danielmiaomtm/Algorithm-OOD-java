/*
For array [1,2,7,8,5], and queries [(1,2),(0,4),(2,4)], return [2,1,5]

Challenge
O(logN) time for each query

*/


public class Solution {
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || queries == null) return res;
        MinTreeNode root = buildTree(A, 0, A.length-1);
        for (Interval i: queries) {
            res.add(getMin(root, i.start, i.end));
        }
        return res;
    }
    //创建新的树结构MinTreeNode
    public class MinTreeNode {
        int start, end, min;
        MinTreeNode left, right;
        public MinTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public MinTreeNode(int start, int end, int min) {
            this(start, end);
            this.min = min;
        }
    }
    //创建新的MinTreeNode
    public MinTreeNode buildTree(int[] A, int start, int end) {
        if (start > end) return null;
        //下面四行语句是recursion的主体
        if (start == end) return new MinTreeNode(start, start, A[start]);
        MinTreeNode root = new MinTreeNode(start, end);
        root.left = buildTree(A, start, (start+end)/2);
        root.right = buildTree(A, (start+end)/2+1, end);
        //下面三行语句设置每个结点的min值
        if (root.left == null) root.min = root.right.min;
        else if (root.right == null) root.min = root.left.min;
        else root.min = Math.min(root.left.min, root.right.min);
        return root;
    }
    //获得最小值min的子程序
    public int getMin(MinTreeNode root, int start, int end) {
        //空集和越界情况
        if (root == null || root.end < start || root.start > end) {
            return Integer.MAX_VALUE;
        }
        //最底层条件结构
        if (root.start == root.end || (start <= root.start && end >= root.end)) {
            return root.min;
        }
        //递归
        return Math.min(getMin(root.left, start, end), getMin(root.right, start, end));
    }
}
