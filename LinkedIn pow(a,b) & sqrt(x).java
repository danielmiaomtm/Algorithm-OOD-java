public int mySqrt(int x) {
    if (x < 0) {
        return -1;
    }
    if (x == 0) {
        return 0;
    }

    int start = 1, end = x;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (mid < x / mid) {
            start = mid;
        } else if (mid > x / mid) {
            end = mid;
        } else {
            return (int)mid;
        }
    }

    if (start * start <= x) {
        return (int) start;
    }
    return (int) end;

}







public double myPow(double x, int n) {
   if (n == 0) return 1;

    if (n < 0) {
        if (n == Integer.MIN_VALUE) {
            n++;
            return 1 / (myPow(x, Integer.MAX_VALUE) * x);
        }
        n = -n;
        x = 1 / x;
    }

    return (n % 2 == 0) ? myPow(x * x, n / 2): x * myPow(x * x, n / 2);


}
