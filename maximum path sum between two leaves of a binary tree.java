`int maxPathSumUtil(Node node, Res res) {
 
        // Base cases
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return node.data;
 
        int ls = maxPathSumUtil(node.left, res);
        int rs = maxPathSumUtil(node.right, res);
 
        // If both left and right children exist
        if (node.left != null && node.right != null) {
 
            // Update result if needed
            res.val = Math.max(res.val, ls + rs + node.data);
 
            // Return maxium possible value for root being
            // on one side
            return Math.max(ls, rs) + node.data;
        }
 
        // If any of the two children is empty, return
        // root sum for root being on one side
        return (node.left == null) ? rs + node.data
                : ls + node.data;
    }
