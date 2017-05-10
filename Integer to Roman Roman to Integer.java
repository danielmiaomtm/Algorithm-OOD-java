
//从右往左，如果碰到递增的，那就累加，递减的话就减



public String intToRoman(int num) {
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
    
    
    
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
	    }
	    Map<Character, Integer> m = new HashMap<Character, Integer>();
	    m.put('I', 1);
	    m.put('V', 5);
	    m.put('X', 10);
	    m.put('L', 50);
	    m.put('C', 100);
	    m.put('D', 500);
	    m.put('M', 1000);

	    int length = s.length();
	    int result = m.get(s.charAt(length - 1));
	    for (int i = length - 2; i >= 0; i--) {
	        if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
	            result += m.get(s.charAt(i));
	        } else {
	            result -= m.get(s.charAt(i));
	        }
	    }
	    return result;

    }
