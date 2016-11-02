int preStart = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return helper(0,inorder.length - 1,preorder,inorder);
    }
    
    private TreeNode helper(int inStart, int inEnd, int[] preorder, int[] inorder){
    
        if(preStart > preorder.length || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inMid = 0;
        
        for(int i = inStart ; i <= inEnd; i++){
            if(inorder[i] == preorder[preStart]){
                inMid = i;
                break;
            }
        }
        preStart++;
       
        root.left = helper(inStart, inMid - 1, preorder, inorder);
        root.right = helper(inMid + 1, inEnd, preorder, inorder);
        
        return root;
    }
