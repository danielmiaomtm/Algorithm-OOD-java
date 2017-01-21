根据end time 进行排序，然后再找到几个不overlapping的区间。
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




/*
There are a number of spherical balloons spread in two-dimensional space. 
For each balloon, provided input is the start and end coordinates of the horizontal diameter. 
Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. 
Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. 
A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. 
There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. 
The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons)
*/


public int findMinArrowShots(int[][] points) {
    if (points == null || points.length == 0 || points[0].length == 0) {
        return 0;
    }
    Arrays.sort(points, new Comparator <int[]>(){
        public int compare (int[] nums1, int[] nums2) {
            return nums1[1] - nums2[1];        
        }
    });

    int result = 1;
    int[] pre = points[0];
    for (int i = 1; i < points.length; i++) {
        if (points[i][0] > pre[1]) {
            result++;
            pre = points[i];
        }
    }
    return result;
}

