//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public int maxPoints(Point[] points) {
        if (points.length <= 1)
            return points.length;
        int maxUniv = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            Point cur = points[i];
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int howManyCur = 1, maxLocal = 0;
            for (int j = i + 1; j < points.length; j++) {   //这里可以从i+1开始，之前的都算过了
                    Point iter = points[j];
                    if (iter.x == cur.x && iter.y == cur.y) {//同一顶点
                        howManyCur += 1;
                    } 
                    else {          //不同顶点
                        String key = getSlopeInString(cur, iter);
                        //map里存(过cur点,斜率key)代表的直线有多少除了cur的点
                        map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
                        maxLocal = Math.max(maxLocal, map.get(key));
                    }
            }
            maxLocal = howManyCur + maxLocal;
            maxUniv = Math.max(maxLocal, maxUniv);
        }
        return maxUniv;
    }
    public String getSlopeInString(Point cur, Point iter) {
        int numerator = iter.y - cur.y;
        int denominator = iter.x - cur.x;
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "INF";
        }
        String sign = getSign(numerator, denominator);
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));//0和任意一个非零数'a'的gcd为'a',0和0的gcd为0,所以斜率为无穷的情况分母为0
        return sign + Math.abs(numerator)/gcd + "/" + Math.abs(denominator)/gcd;
    }
    //a和b为非负整数 且 a和b不同时为0
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    public String getSign(int a, int b) {
        if (a <= 0 && b <= 0 || a >= 0 && b >= 0)
            return "+";
        else 
            return "-";
    }
