public int myAtoi(String str) {
        // 判断是否为空和长度是否为0
        if(str == null || str.length() == 0)
            return 0;

        // 去掉字符串首尾的空格
        str = str.trim();

        int sign = 1, start = 0, len = str.length();
        long sum = 0;

        // 判断符号
        char firstChar = str.charAt(0);
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) // 判断是否为数字
                return (int) sum * sign;

            sum  = sum * 10 + str.charAt(i) - '0';

            // 判断是否越界
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) sum * sign;
    }
