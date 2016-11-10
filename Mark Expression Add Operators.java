/*
Given a string that contains only digits 0-9 and a target value, 
return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/ 
 public class Solution {
      public List<String> addOperators(String num, int target) {
          List<String> result = new ArrayList<>();
          helper (num, target, "", 0, 0, result);
          return result;
      }
      public void helper (String num, int target, String temp, long curRes, long preNum, List<String> result) {
          if (curRes == target && num.length() == 0) {
              result.add(temp);
              return;
          }
          for (int i = 1; i <= num.length(); i++) {
              String curStr = num.substring(0, i);
              if (curStr.length() > 1 && curStr.charAt(0) == '0') {
                  return;
              }
              long curNum = Long.parseLong(curStr);
              String next = num.substring(i);
              if (temp.length() != 0) {
  //mul
                  helper (next, target, temp + "*" + curNum, (curRes - preNum) + preNum * curNum, preNum * curNum, result);
  //add
                  helper (next, target, temp + "+" + curNum, curRes + curNum, curNum, result);
  //min
                  helper (next, target, temp + "-" + curNum, curRes - curNum, - curNum, result);
              } else {
  //first Char
                  helper (next, target, curStr, curNum, curNum, result);
              }
          }

      }
  }
