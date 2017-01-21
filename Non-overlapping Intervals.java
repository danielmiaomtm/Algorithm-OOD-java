/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*/




public int eraseOverlapIntervals(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
        return 0;
    }
    // sorted by end, because there could be very large start time interval, and by end time could handle that
    // [1,4] [2,3] [3,4]
    Arrays.sort(intervals, new Comparator<Interval>() {
        public int compare (Interval i1, Interval i2) {
            return i1.end - i2.end;
        }
    });
    int count = 1;
    Interval pre = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i].start >= pre.end) {
            count++;
            pre = intervals[i];
        }
    }
    return intervals.length - count;
}
