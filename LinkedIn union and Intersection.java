/*
Union and Intersection of two sorted arrays
Given two sorted arrays, find their union and intersection.

For example, if the input arrays are: 
arr1[] = {1, 1, 2, 3, 5}
arr2[] = {1, 1, 1, 2, 7}
Then your program should print Union as {1,2,3,5,7} and Intersection as {1, 2}. 
*/

给两个字符串
s1 [1,2,3,4]
s2 [1,3,4,5]
返回
common:[1, 3, 4]
diff:[2,5]



public class Main {
	public static void main(String[] args) {
		//nums are sorted.
		int[] nums1={1,1,1,2,2,2,2,3,3,4,4,4};
		int[] nums2={1,1,3,3,4,4,4,5,5,5,5,5,5,5,5};
		List<List<Integer>> res=test(nums1,nums2);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
		
    }
	 public static List<List<Integer>> test(int[] nums1, int[] nums2) {
		 List<List<Integer>> res = new ArrayList<>();
	     List<Integer> diff = new ArrayList<>();
	     List<Integer> common = new ArrayList<>();
	     res.add(diff); res.add(common);
	     int p1 = 0;
	     int p2 = 0;
	     while(p1<nums1.length || p2<nums2.length){
	    	 if(p2 == nums2.length || ( p1 < nums1.length && nums1[p1] < nums2[p2])){
                 diff.add(nums1[p1++]);            
             }else if(p1 == nums1.length || nums1[p1] > nums2[p2]){
            	 diff.add(nums2[p2++]);
             }else{
            	 common.add(nums1[p1]);
            	 p1++; p2++;
	         }
	    	 while(p1 > 0 && p1 < nums1.length && nums1[p1] == nums1[p1-1]) p1++;
             while(p2 > 0 && p2 < nums2.length && nums2[p2] == nums2[p2-1]) p2++;
	        }
	        return res;
	 }
}





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









// iterator 
public static Iterable<Integer> intersection(Iterator<Integer> a, Iterator<Integer> b) {
	List<Integer> intersection = new ArrayList<>();
	List<Integer> union = new ArrayList<>();

	Integer currA = a.hasNext() ? a.next() : null;
	Integer currB = b.hasNext() ? b.next() : null;

	while (currA != null && currB != null) {
	    if (currA.intValue() == currB.intValue()) {
		
		intersection.add(currA);
		union.add(currA);
		
		currA = a.hasNext() ? a.next() : null;	                	                
		currB = b.hasNext() ? b.next() : null;

	    } else if (currA.intValue() < currB.intValue()) {
		
		union.add(currA);
		
		currA = a.hasNext() ? a.next() : null;
	    } else {
		union.add(currB);
		currB = b.hasNext() ? b.next() : null;
	    }
	}
	
	while (currA != null) {
		union.add(currA);
		currA = a.hasNext() ? a.next() : null;
	}
	while (currB != null) {
		union.add(currB);
		currB = b.hasNext() ? b.next() : null;
	}
	return union;
}


