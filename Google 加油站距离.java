/*
一条直线上有很多加油站，现在可以再添加K个加油站，要求最小化相邻加油站之间的最大距离，输出添加的位置。
follow up问如果不是直线而是环怎么办，基本是一样的。
*/




 一样维持一个最大堆 里头放的结构类似这样
class Interval{
    int numberAdded;
    int distance;
}

numberAdded是“已经在这个区间加入的加油站的个数” 一开始所有都预设为0
distance就是形成著个区间的两个加油站之间的距离

最大堆依照(distance/(numberAdded+1))做比较
每次poll堆顶的Interval出来 把该Interval的numberAdded+1, 直到加入了k个加油站
此时堆顶的(Interval.distance/(numberAdded+1)) 就会是答案
