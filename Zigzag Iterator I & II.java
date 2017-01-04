/*
Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
*/

public class ZigzagIterator {
	int cur;
	Iterator<Integer> i1;
	Iterator<Integer> i2;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.i1 = v1.iterator();
		this.i2 = v2.iterator();
		this.cur = 0;
	}
	public int next() {
		if (!hasNext()) {
			return 0;
		}
		cur++;
		if ((cur % 2 == 1 && i1.hasNext()) || (!i2.hasNext())) {
			return i1.next();
		} else if ((cur % 2 == 0 && i2.hasNext()) || (!i1.hasNext())) {
			return i2.next();
		} 
		return 0;
	}
	public boolean hasNext() {
		return i1.hasNext() || i2.hasNext();
	}
}


/*

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18): The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
*/


public class ZigzagIterator implements Iterator<Integer> {
	List<Iterator<Integer>> list; 
	int turn;
	public ZigzagIterator(List<Iterator<Integer>> list) {
		this.list = new LinkedList<>();
		for (Iterator<Integer> i : list) {
			if (i.hasNext()) {
				list.add(i);
			}
		}
		this.turn = 0;
	}
	public Integer next() {
		if (!hasNext()) {
			return 0;
		}
		Integer result = 0;
		int pos = turn % list.size();
		Iterator<Integer> cur = list.get(pos);
		result = cur.next();
		if (!cur.hasNext()) {
			list.remove(turn % list.size());
			turn = pos - 1;
		}
		turn++;
		return result;
	}
	public boolean hasNext() {
		return list.size() > 0;
	}
}
