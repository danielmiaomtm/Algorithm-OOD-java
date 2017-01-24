／*
给你一个 String和一个数字max,比如：“happy new year new year” max =2Max表示最长的可以有几个单词（要是在string中连续的单词）。
返回所有的可能单词和次数这个例子返回： happy 1new 2year 2happy new 1new year 2year new 1
input : "Happy new year new yar" maxLen = 9
output :
new new
1
 new
3
 year
2
 year year
1
 new year
1
 Happy
1
 Happy new
1
 Happy year
1
 year new
1
 new new new
1


*／


 Map<String, Integer> map = new HashMap<>();
        String input = "Happy new year new year";
        String[] inputs = input.split(" ");
        sol.helper(inputs, 9, map, "", 0, 0);
        
        for (String key : map.keySet()) {
        	System.out.println(key);
        	System.out.println(map.get(key));
        }
        
        


	public void helper (String[] inputs, int maxLen, Map<String, Integer> map, String str, int index, int spaceCount) {

	    if (map.containsKey(str) || (str.length() - spaceCount > maxLen)) {
	        return;
	    }
	    
	    if (str.length() > 0) {
	        int count = maxLen / (str.length() - spaceCount);
	        map.put(str, count);
	    } 
	    
	    for (int i = index; i < inputs.length; i++) {
	        helper(inputs, maxLen, map, str + " " + inputs[i], index + 1, spaceCount + 1);
	    }
	    
	}
	
