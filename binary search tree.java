//insert 
public TreeNode insert (Node root, int key) {
  if (root == null) {
    return new TreeNode(val);
  } 

  if (root.val < key) {
    root.right = insert(root.right, key);
  }  else if (root.val > key){ 
    root.left = insert(root.left, key);
  }
  return root;
}

//find

public boolean find (Node root, int key) {
  if (root == null) {
    return false;
  }
  if (root.val == key) {
    return true;
  }
  return  find(root.left, key) || find (root.right, key);
}

//delete

public Node deleteRec(Node root, int key) {
    /* Base Case: If the tree is empty */
    if (root == null)  return root;

    /* Otherwise, recur down the tree */
    if (key < root.key)
        root.left = deleteRec(root.left, key);
    else if (key > root.key)
        root.right = deleteRec(root.right, key);

    // if key is same as root's key, then This is the node
    // to be deleted
    else
    {
        // node with only one child or no child
        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;

        // node with two children: Get the inorder successor (smallest
        // in the right subtree)
        root.key = minValue(root.right);

        // Delete the inorder successor
        root.right = deleteRec(root.right, root.key);
    }

    return root;
}

int minValue(Node root)
{
    int minv = root.key;
    while (root.left != null)
    {
        minv = root.left.key;
        root = root.left;
    }
    return minv;
}
