/*
Input: str = "abaaa"
Output:  Below are 5 palindrome sub-strings
a
aa
aaa
aba
b


Input: str = "geek"
Output:  Below are 4 palindrome sub-strings
e
ee
g
k
*/


public List<String> findAllPal (String str) {

        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        for (int i = 0; i < str.length(); i++) {
            helper(str, i, 0, result);
            helper(str, i, 1, result);
        }
        return result;
    }
    public void helper (String str, int index, int diff, List<String> result) {

        int left = index;
        int right = index + diff;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            String temp = str.substring(left, right + 1);
            if (!result.contains(temp)) {
                result.add(temp);
            }
            
            left--;
            right++;
        }
    }
