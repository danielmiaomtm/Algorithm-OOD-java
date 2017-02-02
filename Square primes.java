public List<Integer> printPrime (int n) {
    List<Integer> result = new ArrayList<>();
    // primes starts from 2
    if (n < 2) {
      return result;
    }

    boolean[] primes = new boolean[n + 1];

    for (int i = 2; i <= n; i++) {
      if (primes[i]) {
        continue;
      }
      for (int j = i * 2; j <= n; j += i) {
        primes[j] = true;
      }
    }

    for (int i = 2; i <= n; i++) {
      if (!primes[i]) {
        result.add(i);
      }
    }
    return result;
  }




