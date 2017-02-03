/*

*/


public class Main {

    //当前位置
    private static int x;
    private static int y;

    private static int[][] a = new int[100][100];

    //当前方向
    private static int direction = 0;

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int m,n;

        m = cin.nextInt();
        n = cin.nextInt();

        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        {
        a[i][j] = cin.nextInt();
        }

        x = cin.nextInt();
        y = cin.nextInt();

        //将方向设置为数字  方向 U R D L
        String dirtemp = cin.next();
        if(dirtemp.equals("R"))
        direction = 1;
        else if(dirtemp.equals("D"))
        direction = 2;
        else if(dirtemp.equals("L"))
        direction = 3;

        //步数
        int k = cin.nextInt();

        for(int i=0;i<k;i++)
        move();

        System.out.print(x+" "+y);
    }


    // 移动的方法
    public static void move() {
        //如果是白的，则左转
        if(a[x][y] == 0) {
          direction = (direction - 1) ;
          if(direction < 0) {
            direction += 4;
          }
          a[x][y] = 1;
        } else if(a[x][y] == 1) {
          //如果是黑的则右转
          direction = (direction + 1)%4;
          a[x][y] = 0;
        }

        switch(direction) {
        case 0:
          x--;
          break;
        case 1:
          y++;
          break;
        case 2:
          x++;
          break;
        case 3:
          y--;
          break;
        }
    }
}
