/*
Union and Intersection of two sorted arrays
Given two sorted arrays, find their union and intersection.

For example, if the input arrays are: 
arr1[] = {1, 3, 4, 5, 7}
arr2[] = {2, 3, 5, 6}
Then your program should print Union as {1, 2, 3, 4, 5, 6, 7} and Intersection as {3, 5}. 
*/

public List<List<Integer>> unionAndIntersection (int[] num1, int[] num2) {
    int i1 = 0, i2 = 0;
    List<Integer> union = new ArrayList<>();
    List<Integer> inter = new ArrayList<>();
    while (i1 < num1.length && i2 < num2.length) {
    //if there is duplicated num in list
      while (i1 != 0 && num1[i1] == num1[i - 1]) {
        i1++;
      }
      while (i2 != 0 && num2[i2] == num2[i2 - 1]) {
        i2++;
      }
        if (num1[i1] < num2[i2]) {
           union.add(num1[i1++]);
        } else if (num1[i1] > num2[i2]) {
            union.add(num2[i2++]);
        } else {
        //if two are the same
          union.add(num1[i1]);
          inter.add(num1[i1]);
          i1++;
          i2++;
        }

    }
    // i1或者i2多加了一次
    while (i1 < num1.length) {
        union.add(num1[i1++]);
    }
    while (i2 < num2.length) {
        union.add(num2[i2++]);
    }
    return nums;
}
