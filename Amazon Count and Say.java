/*
AAAEEEBBB : 3A3E3B
3A3E3B : AAAEEEBBB

*/    
    
    
    public String encode (String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        StringBuilder result = new StringBuilder();
        int start = 0; 
        int i = 1;
        while (i < str.length()) {
            char pre = str.charAt(i - 1);
            char cur = str.charAt(i);
            if (pre != cur) {
                result.append(i - start).append(str.charAt(start));
                start = i;
            }
            i++;
        }
        if (i - start >= 1) {
            result.append(i - start).append(str.charAt(start));
        }
        return result.toString();
    }
    
    
    
    public String decode (String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String result = "";
        int start = 0;
        int i = 0;
        while (i < str.length()) {
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                i++;
            }
            if (i >= str.length()) {
                return "";
            }
            int count = Integer.parseInt(str.substring(start, i));
            char c = str.charAt(i);
            for (int j = 0; j < count; j++) {
                result += "" + c;
            }
            start = i + 1;
            i++;
        }
        return result;
    }
