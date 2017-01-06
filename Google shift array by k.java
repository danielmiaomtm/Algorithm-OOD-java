
/*
right shift the elements in array by k, one simple method is reverse 3 times

find gcd（最大公约数）
(6, 2) = 2;

*/
public int gcd(int num1, int num2) {
  if (num2 == 0) {
    return num1;
  }
  return gcd(num2, num1 % num2);
}

/*
temp = 1
1,2,3,4,5,6
3,2,5,4,1,6
3,4,5,6,1,2
*/
//left shift
public void swapArrs(int[] arrs, int k) {
  int len = arrs.length;
  int gcd = gcd(len, k);
  for (int i = 0; i < gcd; i++) {
    int t = i;
    int j = t + gcd;
    int temp = arrs[i];
    while (j < len) {
      arrs[t] = arrs[j];
      t = j;
      j += gcd;
    }
    arrs[t] = temp;
  }
  
  
/*
k = 2
1,2,3,4,5,6 
4,3,2,1,6,5
5,6,1,2,3,4
*/

//right shift  
public void swapArrs(int[] arrs, int k) {
  int len = arrs.length;
  int gcd = gcd(len, k);
  for (int i = 0; i < gcd; i++) {
    int t = len - 1 - i;
    int j = t - gcd;
    int temp = arrs[t];
    while (j >= 0) {
      arrs[t] = arrs[j];
      t = j;
      j -= gcd;
    }
    arrs[t] = temp;
  }
}
}
