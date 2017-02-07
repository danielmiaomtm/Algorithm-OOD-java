 top 10 logs in last 60 min. Design the entire product, from how to get log data to how to show it in UI.
   
   

是entry level。其实我也不确定我答得算不算好。先确定data 多大，面试官说1000种exception（我之前题目介绍没说清楚，是top 10 的exception），
从很多的server取数据，忘了多少了。然后先简单化问题，如何存和算过去60分钟的exception，问了一下时间的granularity，说是min，
那我就对于每个exception用一个cyclic array 60长度，然后每次time%60来increase对应的count。另外用一个变量存下last t/60，来判断是否该该归零。
然后每次UI call api的时候就对所有的exception排序。 到目前为止就有了一个最粗暴的算法和数据结构，后面是scalability和效率的优化。
比如分布式的时候怎么存你的这些array，一台机器存100个？之类的，然后load balance，数据源server call你的api来push这些exception data，
怎么通过load balance来快速判断被分配到哪个机器，如果只用一台机器来load balance，那这台机器本身就会限制速度，即使每次只是query一下要被分配到
的server地址。所以需要另一个地址server专门存data service的地址map，然后数据源server只要每次call一下这个地址server就知道要发送到哪个data service了
，就省掉了所谓的data balance。之后就是排序的优化，因为实际情况不会每次都出现1000个exception都有非0的数据，所以用一个maxheap比较好，
这样每次维护就是klogn，k一般会很小。然后就没啥了，问了点工作中有没有遇到过类似的top k排序处理之类的。面试官很nice的国人大哥，一路领着我做完了。
万分感谢一下。
