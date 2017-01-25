/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

时间 O(NM) 空间 O(N+M)

*/


public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        int len1 = num1.length(), len2 = num2.length();
        // 结果的位数最多可能是两个乘数位数之和
        int len3 = len1 + len2;
        int[] res = new int[len3];
        int carry = 0, i = 0, j = 0;
        for(i = len1 - 1; i >= 0; i--){
            // 先置carry位为0
            carry = 0;
            for(j = len2 - 1; j >= 0; j--){
                // 每一位的乘积，等于之前这一位的结果，加上carry，再加上这一位和乘数的乘积
                int product = carry + res[i + j + 1] + (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                res[i + j + 1] = product % 10;
                carry = product / 10;
            }
            // 把最后的carry位加上
            res[i + j + 1] = carry;
        }
        StringBuilder resstr = new StringBuilder();
        i = 0;
        // 跳过前面无用的0
        while(i < len3 - 1 && res[i] == 0){
            i++;
        }
        for(; i < len3; i++){
            resstr.append(res[i]);
        }
        return resstr.toString();
    }
    
    
    
    
    
//Add Two Strings   

private String addString(String num1, String num2){
    int i = num1.length() - 1, j = num2.length() - 1;
    int k = Math.max(i, j);
    int[] num3 = new int[k + 1];
    int sum = 0, carry = 0;
    while(i >= 0 || j >= 0){
        // 加数的位
        int d1 = i >= 0 ? (num1.charAt(i) - '0') : 0; 
        // 被加数的位
        int d2 = j >= 0 ? (num2.charAt(j) - '0') : 0;
        sum = d1 + d2 + carry;
        num3[k] = sum % 10;
        carry = sum / 10;
        k--;
        i--;
        j--;
    }
    StringBuilder sb = new StringBuilder();
    // 如果最后还有进位要加上
    if(carry != 0) sb.append(carry);
    for(int digit : num3){
        sb.append(digit);
    }
    return sb.toString();
}

/*
有符号加法
思路
有符号的话，就要根据符合判断具体的操作

如果都是负数，则结果是两个绝对值相加再取负
如果一个是负数一个正数，则结果是（正数）减去（负数的绝对值），这里要用到减法
如果都是正数则直接相加

*/


private static String addSignedString(String num1, String num2){
    int sign1 = 1, sign2 = 1;
    if(num1.charAt(0) == '-'){
        sign1 = -1;
        num1 = num1.substring(1);
    }
    if(num2.charAt(0) == '-'){
        sign2 = -1;
        num2 = num2.substring(1);
    }
    if(sign1 == sign2){
        String res = addString(num1, num2);
        return sign1 == -1 ? "-" + res : res;
    } else {
        if(sign1 == 1){
            return subString(num1, num2);
        } else {
            return subString(num2, num1);
        }
    }
}



/*
时间 O(N) 空间 O(N)

思路
从后向前模拟减法，计算每一位的值时，用减数的位减去被减数，再加上10，再减去借位，结果模上10就行了。借位则是看之前的结果是否小于10，如果小于10说明借位了。
不过要注意的是，我们要用较大的数减去较小的数，如果减数反而较大，我们要用减数减去被减数，然后结果加上负号。
判断两个数的大小的方法，是先判断其长度，如果长度不一样，则较长的较大，如果长度一样，则需要比较每一位。
*/

private static String subString(String num1, String num2){
    int len1 = num1.length(), len2 = num2.length();
    // 根据两数的大小关系，决定是直接相减，还是反过来相减取负
    if(len1 > len2){
        return coreSub(num1, num2);
    } else if (len1 < len2){
        return "-"+coreSub(num2, num1);
    } else {
        int compare = num1.compareTo(num2);
        if(compare > 0){
            return coreSub(num1, num2);
        } else if(compare < 0){
            return "-"+coreSub(num2, num1);
        } else {
            return "0";
        }
    }
}

private static String coreSub(String num1, String num2){
    int i = num1.length() - 1, j = num2.length() - 1;
    int[] num3 = new int[i + 1];
    int diff = 0, borrow = 0;
    while(i >= 0){
        int d1 = num1.charAt(i) - '0';
        int d2 = j >= 0? num2.charAt(j) - '0': 0;
        // 计算差值时要先加上10
        diff = d1 + 10 - borrow - d2;
        num3[i] = diff % 10;
        borrow = diff < 10 ? 1 : 0;
        i--;
        j--;
    }
    i = 0;
    while(num3[i] == 0){
        i++;
    }
    StringBuilder sb = new StringBuilder();
    while(i < num3.length){
        sb.append(num3[i]);
        i++;
    }
    return sb.toString();
}



/*
有符号减法
*/

private static String subSignedString(String num1, String num2){
    int sign1 = 1, sign2 = 1;
    if(num1.charAt(0) == '-'){
        sign1 = -1;
        num1 = num1.substring(1);
    }
    if(num2.charAt(0) == '-'){
        sign2 = -1;
        num2 = num2.substring(1);
    }
    if(sign1 == sign2){
        // 都是正数则直接相减
        if(sign1 == 1){
            return subString(num1, num2);
        // 都是负数则后面减去前面
        } else {
            return subString(num2, num1);
        }
    } else {
        // 前正后负则相加
        if(sign1 == 1){
            return addString(num1, num2);
        // 前负后正则相加后取负
        } else {
            return "-"+addString(num1, num2);
        }
    }
}
