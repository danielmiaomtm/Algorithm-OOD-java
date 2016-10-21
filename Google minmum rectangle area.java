/*
一堆点[(x0,y0), (x1,y1)...] 这样，问能够组成最小的长方形。这题一开始没和他verify，以为是任意角度的长方形，我写的最优解是O(N^3)的。
后来他发现了，说原意是只找和两根坐标轴平行的，就又讲了一个O(N^2)的做法，没写代码，一共半小时吧。。这轮觉得做的挺好。
*/
/*
1.把所有点存入hashset中
2. 从点0到点n的所有点中选取点 i 和点 j (for each i from 0 to n-1, find j from i to n-1)，i 点和 j点分别表示长方形的左下角和右上角. 做如下循环：
  2.1 假设左下和右上角是（x1, y1）,(x2, y2)，可以推算出左上角为（x1, y2）右下角为（x2, y1）.
  2.2 查找set中是否存在（x1, y2）， （x2, y1）. 若都存在，计算面积并更新最小面积
3. 输出最小面积。
*/
class Point{
  private int x;
  private int y;
  public Point (int x, int y) {
    this.x = x;
    this.y = y;
  }
}
public int minRectArea (Point[] points) {
  int result = 0;
  Set<Point> set = new HashSet<>();
  for (Point point : points) {
    set.add(point);
  }
  List<Point> list = new ArrayList<>();
  for (Point p : set) {
    list.add(p);
  }
  for (int i = 0; i < list.size(); i++) {
    Point leftBottom = list.get(i);
    for (int j = i; j < list.size(); j++) {
      Point rightUpper = list.geT(j);
      //leftUpper
      Point leftUpper = new Point (rightUpper.x, leftButtom.y);
      //rightBottom
      Point rightBottom = new Point(leftButtom.x, rightUpper.y);
      if (set.contains(leftUpper) &&& set.contains(rightBottom)) {
        int max = (rightButtom.y - leftUpper.y) * (leftUpper.x - rightButtom.x);
        result = Math.max(result, max);
      }
    }
  }
  return result;
}
