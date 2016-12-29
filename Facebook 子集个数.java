/*
一个array, [1,3,5,7,4,8,2], 一个 target k, 找出这个array里所有子集的个数，满足：子集里最小和最大的数相加小于等于k.

*/

public static int minMaxSum(int[] input, int k) {
    int res = 0;
    Arrays.sort(input);
    for (int i = 0; i < input.length && input[i] <= k; i++) {
        for (int j = input.length - 1; j >= i; j--) {. visit 1point3acres.com for more.
            if (input[i] + input[j] <= k) {
                res += (int)Math.pow(2, j - i); // calculate the num of all combinations including i as start and maximum j as end;
                break;
            }
        }
    }
    return res;
}
