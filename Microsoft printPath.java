/*
一个tree结构不一定是binary tree，存的都是正数，找到一个从root开始的route，经过 的node的value加起来是某个K值，然后返回这个路径。
 search    combination sum
*/
class Tree {
    List<Tree> list;
    int val;
    Tree (int val) {
        this.val = val;
        this.list = new ArrayList<>();
    }
}

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        myCode sol = new myCode();
        
        Tree node = new Tree(1);
        node.list.add(new Tree(2));
        node.list.add(new Tree(3));
        node.list.add(new Tree(5));
        
        node.list.get(0).list.add(new Tree(3));
        node.list.get(0).list.add(new Tree(3));
        
        node.list.get(1).list.add(new Tree(2));
        node.list.get(1).list.add(new Tree(4));
        
        node.list.get(2).list.add(new Tree(1));
        node.list.get(2).list.add(new Tree(2));
  
        List<List<Integer>> result = sol.printPath(node, 6);
        
        for (List<Integer> l : result) {
            System.out.println(Arrays.toString(l.toArray()));    
        }
        
        
    }
    
  public List<List<Integer>> printPath (Tree root, int target) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> list = new ArrayList<>();
      helper(root, 0, target, list, result);
      return result;
  }
  public void helper (Tree root, int num, int target, List<Integer> list, List<List<Integer>> result) {
      
      if (num + root.val == target) {
          list.add(root.val);
          result.add(new ArrayList<>(list));
          list.remove(list.size() - 1);
      }
      for (Tree node : root.list) {
          list.add(root.val);
          helper(node, num + root.val, target, list, result);
          list.remove(list.size() - 1);
      }
   
  }

                                        
                                             
}
