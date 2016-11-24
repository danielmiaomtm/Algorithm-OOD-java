/*Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Example
Given [1, 0, 1, 2], return [0, 1, 1, 2].
*/
public void sortColors(int[] a) {
      if(a == null || a.length <= 1)
          return;

      int pl = 0; //the last 0's index + 1 OR the first 1's position
      int pr = a.length - 1; //the first 2's index - 1 OR the last 1's position
      int i = 0;
      while(i <= pr){
          if(a[i] == 0){
              swap(a, pl, i);
              pl++;
              i++;
          }else if(a[i] == 1){
              i++;
          }else{
              swap(a, pr, i);
              pr--;
          }
      }
  }

  private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }
  
/*  
  Given an array of n objects with k different colors (numbered from 1 to k), 
  sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, … k.

Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
*/


public void sortColors2(int[] colors, int k) {
      int pl = 0;
      int pr = colors.length - 1;
      int i = 0;
      int min = 1, max = k;
      while (min < max) {
          while (i <= pr) {
              if (colors[i] == min) {
                  swap(colors, pl, i);
                  i++;
                  pl++;
              } else if (colors[i] == max) {
                  swap(colors, pr, i);
                  pr--;
              } else {
                  i++;
              }
          }
          i = pl;
          min++;
          max--;
      }
  }

  private void swap(int[] colors, int i, int j) {
      int temp = colors[i];
      colors[i] = colors[j];
      colors[j] = temp;
  }
