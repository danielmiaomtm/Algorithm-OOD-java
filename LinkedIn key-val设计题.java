有人问key - value的设计题，这是我的一些理解，欢迎大家讨论指正

这是一个很有意思的题目，主要是考高并发下的key value存储系统，我一开始从
distibute hash入手，讲了讲分布式存储系统，类似 Dynamo. 后来面试官让我设计单
服务器上put, get, delete, update。可以借鉴GFS，比如以64K为存储块(block), 存
储块大小可以和面试官讨论，如果存储的value比较大，就用大的存储块(GFS是64M)，
在内存中维护一个Index(Key -> Block), 每次读写操作以存储块为单位，
1. Put: 在内存中写，写满64M，写入硬盘
2. Get: 根据Index找到对应存储块，如果存储块不在内存，从硬盘中读出，按LRU更新
内存中存储块，然后块内顺序查找
3. Delete:  直接从index上删除key，后台运行一个垃圾回收的程序，专门负责清理，
合并存储块
4. Update： Copy on Write, 先将原来的值copy出来存入新的块，update完成后
update index，这样可以避免读写冲突的问题。原来的内容会被垃圾回收处理。
