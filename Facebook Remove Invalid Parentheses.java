/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

*/


public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        char[] par = new char[]{'(', ')'};
        helper(result, s, 0, 0, par);
        return result;
    }
    public void helper (List<String> result, String s, int endi, int endj, char[] par) {
        int stack = 0;
        for (int i = endi; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            // when there is additional ')' occur, so there could be possible solution (0, i)
            for (int j = endj; j <= i; j++) {
                if (s.charAt(j) == par[1] 
                    && (j == endj || s.charAt(j - 1) != par[1])) {
                    helper(result, s.substring(0, j) + s.substring(j + 1, s.length()), i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            helper(result, reversed, 0, 0, new char[]{')', '('});
        } else {
            result.add(reversed);
        }
    }
}
