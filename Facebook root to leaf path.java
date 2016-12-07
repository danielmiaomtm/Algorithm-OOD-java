/*
lc有一个类似的题，binary tree 从root到leaf的所有path，只不过用list存结果，不是string

 tree           1
               / \          
             3    2        
    　　　 　/　    \
　　　　　 ４　　    ３
　　　　　　　　　　   \
　　　　　　　　　　    ２
最右边的那个ｐａｔｈ输出应该是：　１－１－２－３－１－２－３－２
output:
[1, 3]
[1, 1, 2, 4]
[1, 1, 2, 3, 1, 2, 3, 2]
*/

public List<List<Integer>> getPath (TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(result, list, temp, root, target);
        return result;
    }
    public void helper (List<List<Integer>> result, List<Integer> list, List<Integer> temp, TreeNode root, int target) {
        if (root == null) {
            return;
        }
        //copy the previous visited nodes
        if (root.val == target) {
            for (int num : temp) {
                list.add(num);
            }
        }
        //return if hits to the leaf node
        if (root.left == null && root.right == null) {
            list.add(root.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }

        list.add(root.val);
        temp.add(root.val);

        helper(result, list, temp, root.left, target);
        helper(result, list, temp, root.right, target);

        list.remove(list.size() - 1);
        temp.remove(temp.size() - 1);

    }                           
