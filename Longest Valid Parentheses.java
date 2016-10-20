/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

class Node {
    int val;
    char c;
    Node(int val, char c) {
        this.val = val;
        this.c = c;
    }
}
public class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Node> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Node node = new Node(i, c);
            if (c == '(') {
                stack.push(node);
            } else {
                
                    if (!stack.isEmpty() && stack.peek().c == '(') {
                        int curLen = 0;
                        stack.pop();
                        if (stack.isEmpty()) {
                            curLen = i + 1;
                        } else {
                            curLen = i - stack.peek().val;
                        }
                        result = Math.max(result, curLen);
                    } else {
                        stack.push(node);
                    }
                
            }
        }

        return result;

    }
}
