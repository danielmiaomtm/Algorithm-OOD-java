    double pow(double x, int n) {      
        if (n == 0)
            return 1.0;
        if (x == 0)
            return 0.0;
        double half = pow(x,n/2);
        if(n%2 == 0)
            return half*half;
        else if(n > 0)
            return half*half*x;
        else
            return half*half/x;
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
