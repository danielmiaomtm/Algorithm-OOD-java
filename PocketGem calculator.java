
//+-*/

public static Integer calculator (String input) {
	input = input.replaceAll(" ", "");
	if (input == null || input.length() == 0) {
		return null;
	}
	int num = 0;
	char pre_sign = '+';

	Stack<Integer> stack = new Stack<>();

	for (int i = 0; i < input.length(); i++) {
		char c = input.charAt(i);
		if (Character.isDigit(c)) {
			num = num * 10 + (c - '0');
		}
		if (!Character.isDigit(c) || i == input.length() - 1) {
			if (pre_sign == '+') {
				stack.push(num);
			} else if (pre_sign == '-') {
				stack.push(-num);
			} else if (pre_sign == '*') {
				int temp = stack.pop();
				stack.push(temp * num);
			} else if (pre_sign == '/') {
				int temp = stack.pop();
				stack.push(temp / num);
			}
			num = 0;
			pre_sign = c;
		}
	}
	int result = 0;
	while (!stack.isEmpty()) {
		result += stack.pop();
	}
	return result;
}
