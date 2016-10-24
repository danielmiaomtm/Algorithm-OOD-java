class Result {
  int id;
  int val;
  public Result (int id, int val) {
    this.id = id;
    this.val = val;
  }
}


public static Map<Integer, Double> getHighFive(Result[] results){

        Map<Integer, Double> result = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (Result res : results) {
            if (map.containsKey(res.id)) {
                PriorityQueue<Integer> heap = map.get(res.id);
                heap.offer(res.val);
                if (heap.size() > 5) {
                    heap.poll();
                }
                map.put(res.id, heap);
            } else {
                PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer> () {
                    public int compare (Integer i1, Integer i2) {
                        return i1 - i2;
                    }
                });
                heap.offer(res.val);
                map.put(res.id, heap);
            }
        }
        for (Integer id : map.keySet()) {
            double sum = 0;
            PriorityQueue<Integer> heap = map.get(id);
            while (!heap.isEmpty()) {
                sum += map.get(id).poll();
            }
            sum /= 5.0d;
            result.put(id, sum);
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);

        System.out.println(res.get(1) + " " +res.get(2));
    }
