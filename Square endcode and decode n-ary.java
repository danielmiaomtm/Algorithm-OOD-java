class Node {
	  List<Node> children;
	  String val;
	  int index;
	  
	  Node (String val) {
	    this.val = val;
	    this.children = new ArrayList<>();
	  }
	  public void addChild (Node child) {
	    children.add(index++,child);
	  }
	  
	}

public class practise {
	
  
	  public static void main (String[] args) {
		practise sol = new practise();
		
		
	    Node one = new Node("one");
	    Node two = new Node("two");
	    Node three = new Node("three");
	    Node four = new Node("four");
	    Node five = new Node("five");
	    Node six = new Node("six");
	    Node seven = new Node("seven");
	    Node eight = new Node("eight");
	    
	    one.addChild(two);
	    one.addChild(three);
	    one.addChild(four);
	    
	    two.addChild(five);
	    two.addChild(six);
	    
	    three.addChild(seven);
	    four.addChild(eight);
	    
	    String input = "a123a45a67";
//	    System.out.println(input.indexOf("a", 0));
//	    System.out.println(input.indexOf("a", 1));
	    System.out.println(sol.serialize(one));
	    Node result = sol.decode(sol.serialize(one));
	  }
	  
	  
		public String serialize(Node root) {
			StringBuilder sb = new StringBuilder();
			serializeRecursive(root, sb);
			return sb.toString();
		}
	 
	 
		private void serializeRecursive(Node root, StringBuilder sb) {
			if (root == null){
				return;
			}
	 
			sb.append(root.val.length()).append("*").append(root.val);
			for(Node node : root.children){
				serializeRecursive(node, sb);
			}
			sb.append(')');
		}
		  
		
		int index = 0;
		int pos = 0;
		int count = 0;
		  public Node decode (String input) {
		    if (input == null || input.length() == 0) {
		      return null;
		    }
		    return decodeHelper(input);
		  }
		  public Node decodeHelper (String input) {
		    if (index >= input.length() || input.charAt(index) == ')') {
		      return null;
		    }
		    
		    pos = input.indexOf('*', index);
		    count = Integer.parseInt(input.substring(index, pos));
		    String val = input.substring(pos + 1, pos + count + 1);

		    
		    Node root = new Node(val);

		    while (index < input.length()) {
		    	if (input.charAt(index) == ')') {
		    		index++;
		    	} else {
		    		index = pos + count + 1;
		    	}

		    	
		      Node child = decodeHelper(input);
		      if (child == null) {
		        break;
		      }
		     
		      root.addChild(child);
		    }
		    
		    return root;
		  }

}
