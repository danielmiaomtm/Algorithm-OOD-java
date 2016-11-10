
//Time complexity (O(n^2)) 
//SPace Complexity (O(n))


  int NthPrime(int n){
      ArrayList<Intger> primes = new ArrayList<Integer>();
      primes.add(2);
      int number = 3;
      while (primes.size() < n){
          boolean isPrime = true;
          for (int i = 0; i < primes.size(); i++){
              if (number % primes.get(i) == 0){
                  isPrime = false;
              }
          }
          if (isPrime){
              primes.add(number);
          }       
          number += 2;
      }
      return primes.get(n-1);
  }
  
  
// count number of primes under n; or return the max prime number under n
  public int countPrimes(int n) {
        if (n < 3)
        return 0;

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                for (int j = i * 2; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }
