	public static int evaluate(String expression)
    {
        char[] str = expression.toCharArray();
        Stack<Integer> values = new Stack<Integer>();// Stack for numbers: 'values'
        Stack<Character> ops = new Stack<Character>();// Stack for Operators: 'ops'
        for (int i = 0; i < str.length; i++)
        {
            if (str[i] == ' ')// Current token is a whitespace, skip it
                continue;
            if (str[i] >= '0' && str[i] <= '9')// Current token is a number, push it to stack for numbers
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < str.length && str[i] >= '0' && str[i] <= '9')
                    sbuf.append(str[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
            }
            else if (str[i] == '(')// Current token is an opening brace, push it to 'ops'
                ops.push(str[i]);
            else if (str[i] == ')')// Closing brace encountered, solve entire brace
            {
                while (ops.peek() != '(')
                  values.push(calculator(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
            // Current token is an operator.
            else if (str[i] == '+' || str[i] == '-' ||
                     str[i] == '*' || str[i] == '/')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(str[i], ops.peek()))
                  values.push(calculator(ops.pop(), values.pop(), values.pop()));
                // Push current token to 'ops'.
                ops.push(str[i]);
            }
        }
        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(calculator(ops.pop(), values.pop(), values.pop()));
        // Top of 'values' contains result, return it
        return values.pop();
    }
 
    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char cur, char inStack)
    {
        if (inStack == '(' || inStack == ')')
            return false;
        if ((cur == '*' || cur == '/') && (inStack == '+' || inStack == '-'))
            return false;
        else
            return true;
    }
 
    // A utility method to apply an operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    public static int calculator(char op, int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }

