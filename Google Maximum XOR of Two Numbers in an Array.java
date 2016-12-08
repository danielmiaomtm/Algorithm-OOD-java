/*
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.


[14, 11, 7, 2] -> [1110, 1011, 0111, 0010]

mask = 1000
set[1000, 0000]
temp = 1000 ^ set ->[0000] contains
result = 1000;

mask = 1100
set[1100, 1000, 0100, 0000]
temp = 1100 ^ set ->[0000] contains
result = 1100;

mask = 1110
set[1110, 1010, 0110, 0010]
temp = 1110 ^ set -> [0000, 0100, 1000, 1100]
result = 1100;

mask = 1111
set[1110, 1011, 0111, 0010]
temp = 1101 ^ set ->[0011, 0110, 1010, 1111]
result = 1100

*/

public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int temp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    max = temp;
                }
            }
        }
        return max;
    }
}
