/*
Single Element II
给出 3*n + 1 个的数字，除其中一个数字之外其他每个数字均出现三次，找到这个数字。

样例

给出 [1,1,2,3,3,3,2,2,4,1] ，返回 4
挑战

一次遍历，常数级的额外空间复杂度
*/


//三个相同的数相加，不仅其和能被3整除，其二进制位上的每一位也能被3整除！
//因此我们只需要一个和int类型相同大小的数组记录每一位累加 的结果即可。时间复杂度约为 O((3n+1)⋅sizeof(int)⋅8)

    public int singleNumberII(int[] A) {
        if (A == null || A.length == 0) {
          return -1;
        }
        int result=0;
        int[] bits=new int[32];
        for (int i = 0; i < 32; i++) {
          for(int j = 0; j < A.length; j++) {
              bits[i] += A[j] >> i & 1;
              bits[i] %= 3;
          }
          result |= (bits[i] << i);
        }
        return result;
    }
        
        
        
//Single Element III
/*
给出2*n + 2个的数字，除其中两个数字之外其他每个数字均出现两次，找到这两个数字。

样例

给出 [1,2,2,3,4,4,5,3]，返回 1和5
挑战

O(n)时间复杂度，O(1)的额外空间复杂度
*/


    public List<Integer> singleNumberIII(int[] A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        int n = 0;
        for (int elem : A) {
            n ^= elem;
        }
        n = n & (~(n-1));
        for (int elem : A) {
            if ((elem & n) != 0) {
                res.set(0, res.get(0)^elem);
            }
            else res.set(1, res.get(1)^elem);
        }
        return res;
    }
