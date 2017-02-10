public class practise {
	

	  public static void main (String[] args) {

		  List<String> strs = new ArrayList<>();
		  
		  for (int i = 1; i <= 26; i++) {
			  strs.add(intToRoman(i));
		  }
		  System.out.println(Arrays.toString(strs.toArray()));
		  
		  System.out.println(encode(strs, "cat"));
		  
		  List<String> result = decode(strs, "IIII");
		  System.out.println(Arrays.toString(result.toArray()));
	  }

	  
	  public static String encode (List<String> strs, String input) {
		  StringBuilder sb = new StringBuilder();
		  for (int i = 0; i < input.length(); i++) {
			  sb.append(strs.get(input.charAt(i) - 'a'));
		  }
		  return sb.toString();
	  }
	  
	  public static List<String> decode (List<String> strs, String input) {
		  List<String> result = new ArrayList<>();
		  helper(result, strs, input, 0, "");
		  return result;
	  }
	  public static void helper (List<String> result, List<String> strs, String input, int index, String str) {
		  if (index >= input.length()) {
			  result.add(new String (str));
			  return;
		  }
		  for (int i = index; i < input.length(); i++) {
			  String cur = input.substring(index, i + 1);
			  //这里可以优化，算出map array里面最大的manLen，如果现在的这个len超过这个maxLen，那就跳过	 		
			  // if exist in the map array
			  for (int j = 0; j < strs.size(); j++) {
				  if (strs.get(j).equals(cur)) {
					  helper(result, strs, input, i + 1, str + (char)('a' + j) + "");
				  } 
			  }
		  }
	  }
	  
	  public static String intToRoman(int num) {
	        if (num <= 0) {
	            return "";
	        }
	        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	        StringBuilder sb = new StringBuilder();
	        
	        int digit = 0;
	        while (num > 0) {
	            int times = num / nums[digit];
	            num -= nums[digit] * times;
	            for (; times > 0; times--) {
	                sb.append(symbols[digit]);
	            }
	            digit++;
	        }
	        return sb.toString();
	        
	    }
	  
	  
}
