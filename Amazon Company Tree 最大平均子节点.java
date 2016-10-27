/*
题目内容
就是给一棵多叉树，表示公司内部的上下级关系。每个节点表示一个员工，节点包含的成员是他工作了几个月(int)，以及一个下属数组(ArrayList<Node>)。
目标就是找到一棵子树，满足：这棵子树所有节点的工作月数的平均数是所有子树中最大的。最后返回这棵子树的根节点。这题补充一点，返回的不能是叶子节
点(因为叶子节点没有下属)，一定要是一个有子节点的节点。

 class Node {
    int val;
    ArrayList<Node> children;
 }
然后函数是传入一整棵树的根节点，输出符合要求的子树根节点。这题也是第三题的候选，也是稍微有一些难度的，同时另一家公司snapchat的onsite面经里面
也有一道类似的题目。刚才已经说了，OA2的题库每一道题都要不仅要碾压，而且要碾碎。

解决思路
这种对某个root，结合它的子树分析的题目，往往要用到后序遍历的想法，就是先递归左边，再递归右边。有热心的读者问不用递归用迭代呢，回忆了一下迭代的
后序遍历又忘了咋写了，所以憋着不准问。对于这道题，对当前根节点的所有children轮番递归，递归之后再领着孩子常回家看看分析一下root，大概就这个思路了。
好像上面没太写清楚，因为在吃panda的时候给队友也没说太明白，空谈误国，上code吧。
只有两点，一个是递归的function一定要有个返回值，不能void。另一个是这题的code真的不长，看着长是测试那段写的。

*/


import java.util.*; //这次差点儿忘了这个
class Node { //这个是题目给好的
    int val;
    ArrayList<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<Node>();
    }
}
//这个类是自己写的,要不不好找,两个成员变量分别是当前的总和和人数
class SumCount{
    int sum;
    int count;
    public SumCount(int sum, int count){
        this.sum = sum;
        this.count = count;
    }
}
public class Company_Tree {
    //两个全局变量用来找最小的平均值,和对应的节点
    private static double resAve = Double.MIN_VALUE;
    private static Node result;
    public static Node getHighAve(Node root){
        if (root == null) return null;
        dfs(root);
        return result;
    }
    //后序遍历递归。
    private static SumCount dfs(Node root){
        // 这里必须先把叶子节点刨掉，注意看我的手法，其实没什么。
        if (root.children == null || root.children.size() == 0){
            return new SumCount(root.val, 1);
        }
        //把当前root的材料都准备好
        int curSum = root.val;
        int curCnt = 1;
        //注意了这里开始遍历小朋友了
        for (Node child : root.children) {
            SumCount cSC = dfs(child);
            //每次遍历一个都把sum,count都加上，更新
            curSum += cSC.sum;
            curCnt += cSC.count;
        }
        double curAve = (double) curSum/curCnt;
        //这里看一下最大值要不要更新
        if (resAve < curAve){
            resAve = curAve;
            result = root;
        }

        return new SumCount(curSum,curCnt);
    }
    //这回测试的code行数有点儿多。
    public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        Node res = getHighAve(root);
        System.out.println(res.val + " " + resAve);
    }
}
