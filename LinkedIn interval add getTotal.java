/*
public interface IntervalLinkedIn {

         /**
     * Adds an interval [from, to] into internal structure.
     */
    void addInterval(int from, int to);

    /**
     * Returns a total length covered by intervals.
     * If several intervals intersect, intersection should be counted only once.
     * Example:
     *
     * addInterval(3, 6)
     * addInterval(8, 9)
     * addInterval(1, 5)
     *
     * getTotalCoveredLength() -> 6
     * i.e. [1,5] and [3,6] intersect and give a total covered interval [1,6].
     * [1,6] and [8,9] don't intersect so total covered length is a sum for both intervals, that is 6.
     *
     *                   _________
     *                                               ___
     *     ____________
     *
     * 0  1    2    3    4    5   6   7    8    9    10
     *
     */
    int getTotalCoveredLength();
}
*/
  // add Time O(n), get Time O(1)
  int totalLen = 0;
  List<int[]> intervals = new ArrayList<>();

  public void addInterval (int from, int to) {
    if (intervals == null) {
        int[] temp = new int[]{from, to};
        totalLen = to - from;
        return new ArrayList<>(temp);
    }

    int insertPos = 0;
    int len = 0;
    for (Interval cur : intervals) {
        if (cur.end < newInterval.start) {
          result.add(cur);
          len += cur.end - cur.start;
          insertPos++;
        } else if (cur.start > newInterval.end) {
            result.add(cur);
            len += cur.end - cur.start;
        } else {
            newInterval.start = Math.min(newInterval.start, cur.start);
            newInterval.end = Math.max(cur.end, newInterval.end);
        }
    }
    len += newInterval.end - newInterval.start;
    result.add(insertPos, newInterval);
    return ;
  }

  public int getTotalCoveredLength() {
    return totalLen;
  }
  









  // add Time O(1), get Time O(nlgn)
   List<int[]> list = new ArrayList<>();
   public void addInterval (int from, int to) {
      list.add(new int[]{from, to});
   }
   
   public int getTotalCoveredLength() {
    int totalLen;
    Collections.sort(list, new Comparator<int[]>() {
      public int compare (int[] arr1, int[] arr2) {
        return arr1[0] - arr2[0];
      }
    });
    
    int[] pre = list.get(0);
    for (int i = 1; i < list.size(); i++) {
        int[] cur = list.get(i);
        if (cur[0] <= pre[1]) {
            pre[0] = Math.min(pre[0], cur[0]);
            pre[1] = Math.max(pre[1], cur[1]);
        } else {
          //  result.add(pre);
            totalLen += pre.end - pre.start;
            pre = cur;
        }
    }

    //result.add(pre);
    return totalLen;
    
   }
