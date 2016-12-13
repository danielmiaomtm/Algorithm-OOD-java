Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?


 public class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0) {
                return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] != b[0]){
                    return a[0] - b[0]; //ascending order
                } else{
                    return b[1] - a[1]; // descending order
                }
            }
        });
     
        ArrayList<Integer> list = new ArrayList<Integer>();
     
        for(int i = 0; i < envelopes.length; i++){
     
            if(list.size() == 0 || list.get(list.size() - 1) < envelopes[i][1]) {
                list.add(envelopes[i][1]);
            }
            
            int l = 0;
            int r = list.size() - 1;
     
            while(l <= r){
                int m = l + (r - l) / 2;
                if(list.get(m) < envelopes[i][1]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
     
            list.set(l, envelopes[i][1]);
        }
     
        return list.size();
    }
}
