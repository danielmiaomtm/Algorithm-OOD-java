/*
Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.

Examples:

Input:  N = 2
Output: 3
// The 3 strings are 00, 01, 10

Input: N = 3
Output: 5
// The 5 strings are 000, 001, 010, 100, 101
*/


class Subset_sum
{
    static  int countStrings(int n)
    {
        int a[] = new int [n];
        int b[] = new int [n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++)
        {
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }
        return a[n-1] + b[n-1];
    }
    /* Driver program to test above function */
    public static void main (String args[])
    {
          System.out.println(countStrings(3));
    }
}


	public List<String> getStr (int n) {
		List<String> result = new ArrayList<>();
		if (n <= 0) {
			return result;
		}
		helper(result, "", 0, n);
		return result;
	}
	public void helper (List<String> result, String str, int index, int len) {
		if (index > len) {
			return;
		}
		if (index == len && !result.contains(str)) {
			result.add(str);
			return;
		}
		
		if (index > 0 && str.charAt(index - 1) == '1') {
			helper(result, str + "0", index + 1, len);
		} else {
			helper(result, str + "1", index + 1, len);
			helper(result, str + "0", index + 1, len);
		}		
		
	}
	
