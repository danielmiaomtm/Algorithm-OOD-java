public String binaryCom (List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        int result = helper (list, 0, list.size() - 1);
        System.out.println(result);
        return Integer.toBinaryString(result);
    }
    public int helper (List<String> list, int start, int end) {
        
        if (start < end) {
            int mid = start + (end - start) / 2;
            
            int left = helper(list, start, mid);            
            int right = helper(list, mid + 1, end);
            
            return addUp(left, right);
        }
        return Integer.parseInt(list.get(start), 2);
    }
    
    public int addUp (int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 ^= num2;
            num2 &= temp;
            num2 <<= 1;
        }
        return num1;
    }
