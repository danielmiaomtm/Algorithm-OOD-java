/*
Union and Intersection of two sorted arrays
Given two sorted arrays, find their union and intersection.

For example, if the input arrays are: 
arr1[] = {1, 1, 2, 3, 5}
arr2[] = {1, 1, 1, 2, 7}
Then your program should print Union as {1,2,3,5,7} and Intersection as {1, 2}. 
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
    // when either i1 or i2 has not ended
    while (i1 < num1.length) {
        union.add(num1[i1++]);
    }
    while (i2 < num2.length) {
        union.add(num2[i2++]);
    }
    List<List<Integer>> result = new ArrayList<>();
    result.add(union);
    result.add(inter);
    return result;
}





/*
[1, 1, 1, 2 ]和[1, 1 , 3]要return [1, 1,1, 2, 3]  [1]
*/
public List<List<Integer>> unionAndIntersection (int[] num1, int[] num2) {
	    int i1 = 0, i2 = 0;
	    List<Integer> union = new ArrayList<>();
	    Set<Integer> inter = new HashSet<>();
	    while (i1 < num1.length && i2 < num2.length) {
	    //if there is duplicated num in list
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
	    List<List<Integer>> result = new ArrayList<>();
	    result.add(union);
	    result.add(new ArrayList<>(inter));
	    return result;
	}
