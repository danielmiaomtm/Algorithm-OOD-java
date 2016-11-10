/*
在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]

样例

如果有4个物品[2, 3, 5, 7]
如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。
如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。
函数需要返回最多能装满的空间大小。
注意

你不可以将物品进行切割。
*/

  public int backPack(int m, int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        boolean full[] = new boolean[m + 1];
        boolean lastFull[] = new boolean[m + 1];
        full[0] = true;
        for (int i = 0; i < A.length; i++) {
            System.arraycopy(full, 0, lastFull, 0, m + 1);
            for (int size = 1; size <= m; size++) {
                if (size >= A[i] && lastFull[size - A[i]]) {
                    full[size] = true;
                } else {
                    full[size] = lastFull[size];
                }
            }
        }
        for (int size = m; size >= 1; size--) {
            if (full[size]) {
                return size;
            }
        }
        return 0;
    }
    
    
/*
给出n个物品的体积 A[i] 和其价值 V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？

样例

对于物品体积[2, 3, 5, 7]和对应的价值[1, 5, 2, 4], 假设背包大小为10的话，最大能够装入的价值为9。
注意

A[i], V[i], n, m均为整数。你不能将物品进行切分。你所挑选的物品总体积需要小于等于给定的m。
*/    
    
    
    public int backPackII(int m, int[] A, int V[]) {
        int[][] res = new int[A.length+1][m+1];
        res[0][0] = 0;
        for (int i=1; i<=A.length; i++) {
            for (int j=0; j<=m; j++) {
                if (j - A[i-1] < 0)
                    res[i][j] = res[i-1][j];
                if (j - A[i-1] >= 0) {
                    res[i][j] = Math.max(res[i-1][j], res[i-1][j-A[i-1]]+V[i-1]);
                }
            }
        }

        return res[A.length][m];
    }
