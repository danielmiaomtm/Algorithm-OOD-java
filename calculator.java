/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), 
the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
*/

public class Solution {
    public int calculate(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int result = 0, sign = 1, num = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(sign);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                while (i < s.length() && Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                    i++;
                }
                i--;
            } else if (c == '-' || c == '+') {
                result += sign * num;
                sign = stack.peek() * (c == '-' ? -1 : 1);
                num = 0;
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            }
        }
        
        result += num * sign;
        
        return result;
    }
}



/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
*/

public class Solution {
    public int calculate(String s) {
        int pos = 1;
        int mul = 0;
        int result = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                if (mul == 0) {
                    pre = num;
                } else if (mul == -1) {
                    pre = pre / num;
                    mul = 0;
                } else if (mul == 1) {
                    pre = pre * num;
                    mul = 0;
                }
                
            } else if (s.charAt(i) == '+') {
                result += pos * pre;
                pos = 1;
            } else if (s.charAt(i) == '-') {
                result += pos * pre;
                pos = -1;
            } else if (s.charAt(i) == '*') {
                mul = 1;
            } else if (s.charAt(i) == '/') {
                mul = -1;
            }
        }
        result += pos * pre;
        
        return result;
        
    }
}
