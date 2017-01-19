/*

Given a dictionary and a word, find the minimum number of deletions needed on the word in order to make it a valid word.
For example, string “catn” needs one deletion to make it a valid word “cat” in the dictionary. 
And string “bcatn” needs two deletions.

input "abcd"  dict"ac, abd, cd"

return 1 abd

*/

public int minNumOfDel (String input, Set<String> dict) {

  if (input == null || input.length() == 0 || dict.contains(input)) {
  return 0;
}
  for (int i = 1; i <= input.length(); i++) {
    if (helper(input, i, dict, new StringBuilder(), 0)) {
      return input.length() - i;
    }
}
  return 0;
}
public boolean helper (String input, int len, Set<String> dict, StringBuilder sb, int index) {

  if (sb.length() == len) {
    if (dict.contains(sb.toString())) {
      System.out.println(sb.toString());
      return true;
    } else {
      return false;	
    }
  }

boolean result = false;
for (int i = index; i < input.length(); i++) {
  sb.append(input.charAt(i));
  result |= helper(input, len, dict, sb, i + 1);
  sb.deleteCharAt(sb.length() - 1);
}
return result;

}
