// str1 - str2

public String addUp(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        int i = str1.length() - 1;
        int j = str2.length() - 1;
       
        while (i >= 0 || j >= 0) {
            int num1 = i < 0 ? 0 : c1[i] - '0';
            int num2 = j < 0 ? 0 : c2[j] - '0';
            
            if (num1 < num2) {
                int diff = num1 + 10 - num2;
                sb.append(diff);
                int temp = i;
                while (temp - 1 >= 0 && c1[temp - 1] == 0) {
                    c1[temp - 1] = 9;
                    temp--;
                }
                c1[temp - 1]--;
                
            } else if (num1 > num2) {
                sb.append(num1 - num2);
                
            } else {
                sb.append("0");
                
            }
            i--;
            j--;
        }
        
        String result = sb.reverse().toString();
        
        for (int k = 0; k < result.length(); k++) {
            if (result.charAt(k) != '0') {
                return result.substring(k);
            }
        }
        return "0";
    }
    
    
    
  //str1 + str2

  public String addUp(String str1, String str2) {
    StringBuilder sb = new StringBuilder();
    int i = str1.length() - 1;
    int j = str2.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
      int num1 = i < 0 ? 0 : str1.charAt(i) - '0';
      int num2 = j < 0 ? 0 : str2.charAt(j) - '0';
      int sum = num1 + num2 + carry;
      sb.append(sum % 10);
      carry = sum / 10;
    }
    return sb.reverse().toString();
  }
