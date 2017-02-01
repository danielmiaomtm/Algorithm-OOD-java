private int[] nums = null;
    private Random random;
    
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();;
    }
    
    public int[] reset() {
        return Arrays.copyOf(nums,nums.length); 
    }
    
    
    public int[] shuffle() {
        // create a copy
        int[] ans = Arrays.copyOf(nums,nums.length); 
        for(int i = nums.length - 1; i > 0; i--){
            // generate a random number within visited elements including current index.
            int swapIndex = random.nextInt(i + 1); 
            swap(ans,i,swapIndex); 
        }
        
        return ans;
    }
    
    private void swap(int[] ans, int from , int to){
        int temp = ans[from];
        ans[from] = ans[to];
        ans[to] = temp;
    }
    
    
    
    
The probability that ith element goes to second last position can be proved to be 1/n by dividing it in two cases.

Case 1: i = n-1 (index of last element):
The probability of last element going to second last position is = 
(probability that last element doesn't stay at its original position) x (probability that the index picked in previous step is picked again so that the last element is swapped)
So the probability = ((n-1)/n) x (1/(n-1)) = 1/n

Case 2: 0 < i < n-1 (index of non-last):
The probability of ith element going to second position = 
(probability that ith element is not picked in previous iteration) x (probability that ith element is picked in this iteration)
So the probability = ((n-1)/n) x (1/(n-1)) = 1/n

We can easily generalize above proof for any other position.
