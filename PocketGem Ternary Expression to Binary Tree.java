/*
I came across this problem that has Ternary expression (a?b:c) and needs the ternary expression to be converted into a Binary tree 
structure.
     a?b:c 

       a
      / \
     b   c

  a?b?c:d:e

     a
    / \
   b   e
  / \
 c   d
*/


public TreeNode strToTree (String str) {
  if (str == null || str.length() == 0) {
    return null;
  }
  if (str.length() == 1) {
    return new TreeNode(str);
  }
  int counter = 0, pos = 0;
  for (int i = 2; i < str.length(); i++) {
    char c = str.charAt(i);
    if (c == '?') {
      counter++;
    } else if (c == ':') {
      if (counter == 0) {
        pos = i;
        break;
      } else {
        counter--;
      }
    }
  }
  
  TreeNode root = new TreeNode(str.charAt(0));
  root.left = strToTree(str.substring(2, pos));
  root.right = strToTree(str.substring(pos + 1));
  return root;
  
}
