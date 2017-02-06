/*
Given a list of child->parent relationships, build a binary tree out of it. All the element Ids inside the tree are unique. 

Example: 

Given the following relationships: 

Child Parent IsLeft 
15 20 true 
19 80 true 
17 20 false 
16 80 false 
80 50 false 
50 null false 
20 50 true 


You should return the following tree: 
50 
/ \ 
20 80 
/ \ / \ 
15 17 19 16 
*/


//use HashMap <Integer, List<Integer>> to store <parent, {left, right}> and then use DFS to construct the tree

public Node getNode (List<Relation> input) {
  Map<Integer, List<Integer>> map = new HashMap<>();
  for (Relation rel : input) {
    if (!map.containsKey(rel.parent)) {
      List<Integer> list = new ArrayList<>();
      list.add(null);
      list.add(null);
      map.put(rel.parent, list);
    }
    if (rel.isLeft) {
      map.get(rel.parent).set(0, rel.child);  
    } else {
      map.get(rel.parent).set(1, rel.child);
    }
  }
  for (Integer key : map.keySet()) {
    if (key == null) {
      if (map.get(key).get(0) != null) {
        return helper(map, map.get(key).get(0));
      } else if (map.get(key).get(1) != null){
        return helper(map, map.get(key).get(1));
      }
    }
  }
  return null;

}

public Node helper (Map<Integer, List<Integer>> map, Integer parent) {
  if (parent == null) {
    return null;
  }
  Node root = new Node(parent);

  if (!map.containsKey(parent)) {
      return root;
    }

  root.left = helper(map, map.get(parent).get(0));
  root.right = helper(map, map.get(parent).get(1));

  return root;
}
