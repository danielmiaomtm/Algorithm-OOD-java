/*
题目内容是这样的，给十几个城市供电，连接不同城市的花费不同，让花费最小同时连到所有的边。给出一系列connection类，
里面是edge两端的城市名和它们之间的一个cost，找出要你挑一些边，把所有城市连接起来并且总花费最小。不能有环，最后所以城市要连成一个连通块。
不能的话输出空表，最后还要按城市名字排序输出，按照node1来排序,如果一样的话再排node2。
输入:
{"Acity","Bcity",1}
("Acity","Ccity",2}
("Bcity","Ccity",3}
输出：
("Acity","Bcity",1}
("Acity","Ccity",2}
补充一句，test case一共有6个。

解决思路
思路会有很多，我的想法是Kruskal+Union Find，将输入的一群connection类（其实就是边）按照cost从小到大排序(Kruskal算法)，然后遍历。
挑出一个connection之后，看一下edge两头的城市属于哪一个团伙(Union Find)。如果落单了就加入，不同团伙就合并，都是落单了就抱团。
最后有两个要求，1.如果MST不存在，那么输出一个空表（应该不是null）。这个可以用union find思想，最后查有几个union，如果大家都是自己人，
那么就正常输出，如果大家是1，有零星2了，那就空表了。2.输出要按照城市的名字排序，这个不难，就正常排序就行。

复杂度分析
OA里面的题复杂度就不管了，能跑出来就行。重点关注test case不通过的情况。不过这个复杂度还是O(ElogE)吧，因为有次对所有E(Edge)的排序，
算是大头，其他的操作没有比这个多的了。test case只想出孤立两个城市，就是一根connection。如果在connections表里面有个从未出现过的城市，
比如铁岭(A-B,C-D,铁岭,法库)，那我是真的没有办法了。




*/

//给好的connection class，两个城市名，和一个cost。
import java.util.*; //这句话极度重要
class Connection{
    String node1;
    String node2;
    int cost;
    public Connection(String a, String b, int c){
        node1 = a;
        node2 = b;
        cost = c;
    }
}
//下面进入正题
public class City_Connections {
private static int unionNum;//这里开个全局变量，不丢人。
//这个static是题目要求的，我自己一般不写，累。
public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections){
    //先把空的情形挡掉
    if (connections == null || connections.size() == 0){
        return new ArrayList<>();
    }

    ArrayList<Connection> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    //这里把cost小的往前排。
    Collections.sort(connections, new Comparator<Connection>() {
        @Override
        public int compare(Connection o1, Connection o2) {
            return o1.cost - o2.cost;
        }
    });

    unionNum = 0;
    for (Connection c : connections){
        String a = c.node1;
        String b = c.node2;
        //看城市是不是连过了，要是可以连，那么就在result里面加上
        if (union(map, a, b)){
            result.add(c);
        }
    }
    //这里要检查一下,是不是所有的城市都属于同一个union
    String find = connections.get(0).node1;
    int union = map.get(find);
    for (String str : map.keySet()){
        // 如果我们中出了一个叛徒，返回空表
        if (map.get(str) != union){
            return new ArrayList<>();
        }
    }
    //这里最后要求按照城市的名字排序
    Collections.sort(result, new Comparator<Connection>() {
        @Override
        public int compare(Connection o1, Connection o2) {
            if(o1.node1.equals(o2.node1)){
                return o1.node2.compareTo(o2.node2);
            }
            return o1.node1.compareTo(o2.node1);
        }
    });
    return result;
}
private static boolean union(Map<String, Integer> map, String a, String b){
    if (!map.containsKey(a) && !map.containsKey(b)){
        map.put(a, unionNum);
        map.put(b, unionNum);
        //这里用了一个新的没用过的数字
        unionNum++;
        return true;
    }
    //只有一方落单,那就加入有组织的一方
    if (map.containsKey(a) && !map.containsKey(b)){
        int aU = map.get(a);
        map.put(b, aU);
        return true;
    }
    if (!map.containsKey(a) && map.containsKey(b)){
        int bU = map.get(b);
        map.put(a, bU);
        return true;
    }
    //两个人都有团伙的情况。
    int aU = map.get(a);
    int bU = map.get(b);
    //如果是自己人,那肯定要踢掉,否则成环了
    if(aU == bU) return false;
    //把所有对方的团伙都吃进来
    for (String s : map.keySet()) {
        if (map.get(s) == bU) map.put(s, aU);
    }
    return true;
}
public static void main(String[] args) {
    ArrayList<Connection> connections = new ArrayList<>();
    //下面的图是个苯环，中间加上了几根，如果想验证空表，去掉几根线就行。
    connections.add(new Connection("A","B",6));
    connections.add(new Connection("B","C",4));
    connections.add(new Connection("C","D",5));
    connections.add(new Connection("D","E",8));
    connections.add(new Connection("E","F",2));
    connections.add(new Connection("B","F",10));
    connections.add(new Connection("E","C",9));
    connections.add(new Connection("F","C",7));
    connections.add(new Connection("B","E",3));
    connections.add(new Connection("A","F",16));
    //这里就输出一下看看结果。
    ArrayList<Connection> res = getLowCost(connections);
    for (Connection c : res){
        System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
    }
}
