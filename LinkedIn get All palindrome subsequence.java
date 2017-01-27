public List<String> allPalindrome (String input) {
        List<String> result = new ArrayList<>();
        if (isPalindrome(input)) {
            result.add(input);
        }
        Set<String> visited= new HashSet<>();
        for (int len = 1; len <= input.length() - 1; len++) {
            for (int i = 0; i + len < input.length() + 1; i++) {
           
                String str1 = input.substring(i, i + len);
            
                if (visited.contains(str1)) {
                    continue;
                } else {
                    if (isPalindrome(str1)) {
                        visited.add(str1);
                        result.add(str1);
                    }    
                }

            }
        }
        return result;
    }  
    
    public boolean isPalindrome (String input) {
        int left = 0, right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
