/*
有一条公路，长度是m, 中间有k个加油站，由此我们可以得到一个加油站之间的最大距离，然后给你一个数t，这个数代表增加的加油站的数量（往里面插入），
求使得加油站之间最大距离变得最小的值，返回这个最小的最大距离
*/


//Wrapper class to hold each distance and number of gas stations within 
public class Wrapper{
    public int distance;
    public int stationCount;.
    public Wrapper(int distance){
      this.distance = distance; this.stationCount = 1;
    }
}

//integer array to store the distance between each two adjancent gas stations
int[] dist; 
// wrapper with higher average distance has higher priority
PriorityQueue<Wrapper> queue = new PriorityQueue<Wrapper>(dist.length, new Comparator<Wrapper>{
    public int compare(Wrapper a, Wrapper b){
        return b.distance / b.stationCount - a.distance / a.stationCount;
    }
});

for (int d : dist) {
    queue.offer(new Wrapper(d));
}
// k is the number of stations to be inserted
while (k > 0) {
    Wrapper w = queue.poll();
    w.stationCount++;
    queue.offer(w);
    k--;
}

Wrapper res = queue.peek();
return res.distance / res.stationCount;
