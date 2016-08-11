/*
You are given a String numbercontaining the digits of a phone number (the number of digits, n, can be anypositive integer) . To help you memorize the number, you want to divide it intogroups of contiguous digits. Each group must contain exactly 2 or 3 digits.There are three kinds of groups:
• Excellent: A group that containsonly the same digits. For example, 000 or 77.
• Good: A group of 3 digits, 2 ofwhich are the same. For example, 030, 229 or 166.
• Usual: A group in which all thedigits are distinct. For example, 123 or 90.
The quality of a group assignment isdefined as
2 × (number of excellent groups) +(number of good groups)
Divide the number into groups suchthat the quality is maximized. Design an
efficient algorithm to return thesolution that maximizes the quality
*/
input : "22202320"
output:
[0, 2, 2, 2, 3, 2, 3, 3]
3

public int helper (String str) {
        if (str.length() <= 1 || str == null) {
            return 0;
        }
        int[] dp = new int[str.length()];
        dp[0] = 0;
        dp[1] = count(str, 0, 1);
        dp[2] = count(str, 0, 2);
        for (int i = 3; i < str.length(); i++) {
            int max1 = dp[i - 3] + count(str, i - 2, i);
            int max2 = dp[i - 2] + count(str, i - 1, i);

            dp[i] = Math.max(max1, max2);
        }
        
        return dp[str.length() - 1];
    }
    //get the ans from string
    public int count (String str, int start, int end) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = start; i <= end; i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                if (i - map.get(c) == 1) {
                    return 2;
                } else {
                    map.put(c, i);
                    max = 1;
                }
            } else {
                map.put(c, i);
            }
        }
        return max;
    }    