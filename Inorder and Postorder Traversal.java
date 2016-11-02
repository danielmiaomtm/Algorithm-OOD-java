 int postEnd = postorder.length - 1;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] postorder, int[] inorder, int inStart, int inEnd){
        if(postEnd < 0 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd--]);
        int inMid = 0;
        // 找到中序序列的根节点
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == root.val){
                inMid = i;
                break;
            }
        }
        // 建好右子树
        root.right = helper(postorder, inorder, inMid + 1, inEnd);
        // 建好左子树
        root.left = helper(postorder, inorder, inStart, inMid - 1);
        return root;
    }
