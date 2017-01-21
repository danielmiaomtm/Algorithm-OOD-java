/*
Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
*/


TreeSet<Interval> treeSet;

public SummaryRanges() {
    treeSet = new TreeSet<Interval>(new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    });
}

public void addNum(int val) {
    Interval temp = new Interval(val, val);
    Interval floor = treeSet.floor(temp);
    if (floor != null && floor.end + 1 == val) {
        temp.start = floor.start;
        treeSet.remove(floor);
    } else if (floor != null && floor.end >= val) {
        return;
    }

    Interval higher = treeSet.higher(temp);
    if(higher != null && higher.start == val + 1){
        temp.end = higher.end;
        treeSet.remove(higher);
    }

    treeSet.add(temp);

}

public List<Interval> getIntervals() {
    return Arrays.asList(treeSet.toArray(new Interval[treeSet.size()]));
}
