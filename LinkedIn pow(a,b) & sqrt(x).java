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




public static double mySqrt(double x, int digit) {
		double start = 0;
		double end = x < 1 ? 1.0 : x;
		double diff = 1 / Math.pow(10, digit);
		while (start < end - diff) {
			double mid = start + (end - start) / 2;
			if (mid == x / mid) {
				return mid;
			} else if (mid > x / mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return (start + end) / 2;
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

//pow(x, n)   iteration
if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) {
            if (n % 2 == 0) return 1;
            else return -1;
        }
        if (n == Integer.MIN_VALUE) return 0;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        double ret = 1.0;
        while (n > 0) {
            if ((n & 1) != 0) 
                ret *= x;
            x = x * x;
            n = n >> 1;
        }
        return ret;
