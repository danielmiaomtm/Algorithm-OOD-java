/*
题目内容
写好了一个叫Result的类，中文翻译成节点，题目是输入是一堆节点，节点里面有两个属性学生id和分数，保证每个学生至少会有5个分数，
求每个人最高的5个分数的平均分。返回的是Map<Integer, Double>, key是id，value是每个人最高5个分数的平均分double是平均分。
感觉就是一堆考卷登记成绩单，但为啥就挑5个呢，等遇到这题让亚马逊给出合乎逻辑的解释。

解决思路
想法就是先把各个成绩按照id聚拢起来。然后排序，高分排前面，低分打断腿，哦不，是不计了。排序就在map里面弄个list，利用Java自带的排序。
而且据说会保证不会有非法数据，比如有人只有4个成绩，那么就正常去做就好啦。

复杂度分析
这个复杂度就遍历了所有的result，priority queue里面排序O(nlgn)，所以就是nlgn，感谢评论区（完了忘了ID了）的指出。
*/


import java.util.*;
class Result{
    int id;
    int value;
    public Result(int id, int value){
        this.id = id;
        this.value = value;
    }
}
public class High_Five {
    public static Map<Integer, Double> getHighFive(Result[] results){
        Map<Integer, Double> map = new HashMap<>();
        //这里pValue的命名,就是每个person都有哪些value。
        Map<Integer, ArrayList<Integer>> pValue = new HashMap<>();
        //对照着ID把成绩塞给对应的人。
        for (Result res : results){
            int id = res.id;
            if (pValue.containsKey(id)){
                //这里curL表示current List
                ArrayList<Integer> curL = pValue.get(id);
                curL.add(res.value);
                pValue.put(id, curL);
            }
            else {
                ArrayList<Integer> curL = new ArrayList<>();
                curL.add(res.value);
                pValue.put(id, curL);
            }
        }
        for (Integer id : pValue.keySet()){
            ArrayList<Integer> list = pValue.get(id);
            //这里写法有些风骚了,就是懒的重写comparator
            Collections.sort(list);
            Collections.reverse(list);
            double value = 0;
            for (int k = 0; k < 5; k++){
                value += list.get(k);
            }
            value = value/5.0;
            map.put(id, value);
        }
        return map;
    }
    public static void main(String[] args) {
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);

        System.out.println(res.get(1) + " " +res.get(2));
    }
}
