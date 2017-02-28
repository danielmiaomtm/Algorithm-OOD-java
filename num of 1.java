class Solution {
  public int  NumberOf1(int n) {         
    int count = 0;      
    //if it is negative, then we need  to turn it into positive and count + 1 for the first 1.
    if(n < 0){             
      n = n & 0x7FFFFFFF;
      ++count;
    }  
    
    while(n != 0) {
      count += n & 1;        
      n = n >> 1;        
    }        
    return count;     
 }
