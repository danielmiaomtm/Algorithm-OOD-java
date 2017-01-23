    
    //n取负数会溢出
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n++;
                return 1/(myPow(x, Integer.MAX_VALUE)*x);
            }
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2): x*myPow(x*x, n/2);
    }


//Write a recursive function to multiply two numbers without using the * operator (or / operator). 
//You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.

// Use the solution from the book to help understanding
    int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProduct(smaller, bigger);
    }

    int minProductHelper(int smaller, int bigger) {
        if (smaller == 0)
            return 0;
        else if (smaller == 1)
            return bigger;

        int s = smaller >> 1; // Divide by 2
        int halfProd = minProductHelper(s, bigger);

        if (smaller % 2 == 0){
            return halfProd + halfProd;
        }
        else {
            return halfProd + halfProd + bigger;
        }
    }
