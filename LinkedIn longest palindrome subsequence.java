  /*
  * Given a string find longest palindromic subsequence in this string.
 *
 * Time complexity - O(n2)
 * Space complexity - O(n2
 *
 * Youtube link - https://youtu.be/_nCsPn7_OgI
 *
 * References
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 
 
  */
  
public int calculate1(char[] str){
      int[][] T = new int[str.length][str.length];
      for(int i = 0; i < str.length; i++){
          T[i][i] = 1;
      }

      for(int col = 1; col < str.length; col++){
          for(int row = 0; row < str.length - col; row++){
              // new col
            int j = row + col;
              if(j == 1 && str[row] == str[j]){
                  T[row][j] = 2;
              }else if(str[row] == str[j]){
                  T[row][j] = T[row + 1][j - 1] + 2;
              }else{
                  T[row][j] = Math.max(T[row + 1][j], T[row][j - 1]);
              }
          }
      }


      return T[0][str.length-1];
  }


    public int calculateRecursive(char str[],int start,int len){
        if(len == 1){
            return 1;
        }
        if(len ==0){
            return 0;
        }
        if(str[start] == str[start+len-1]){
            return 2 + calculateRecursive(str,start+1,len-2);
        }else{
            return Math.max(calculateRecursive(str, start+1, len-1), calculateRecursive(str, start, len-1));
        }
    }
    
    public static void main(String args[]){
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "agbdba";
        int r1 = lps.calculateRecursive(str.toCharArray(), 0, str.length());
        int r2 = lps.calculate1(str.toCharArray());
        System.out.print(r1 + " " + r2);
    }
