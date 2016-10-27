/*
解决思路
对于这种复制题，首先想到的就是用map，进行一一对应。类似『下面一位是来自百合网的男嘉宾，哦他射向了一位女嘉宾，好的这俩人从现在开始一对儿了』。
然后就再遍历一次，把random指针指向的node都通过map抓到，这事儿就结了。当然也有一种每个node都加个尾巴，相当于多加n个节点的做法，个人感觉都差不多，
方法挑一个就好，生男生女都一样，要想富，先修路，少生孩子多种树。
*/


import java.util.*;
class RandomListNode{
    int val;
    RandomListNode next;
    RandomListNode random;
    public RandomListNode(int val){
        this.val = val;
        next = null;
        random = null;
    }
}
public class Deep_Copy_List {
    public static RandomListNode deepCopy(RandomListNode head){
        //建一个对应的映射表
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode point = head;
        while (point != null){
            //来一个,建一个
            RandomListNode cur = new RandomListNode(point.val);
            map.put(point, cur);
            point = point.next;
        }
        point = head; //复位
        while (point != null){
            //开始了复制的旅程
            map.get(point).next = map.get(point.next);
            map.get(point).random = map.get(point.random);
            point = point.next; 
        }
        return map.get(head);
    }
    //这题非常自信的不测试了
    public static void main(String[] args) {

    }
}
