/*
 
 给两个calender schedule, 要设定的meeting time interval， 返回最小的可设置schedule的起始时间。
 sched A: [0,10], [10, 15], [13, 20]
 sched B: [0,5], [27, 33]
 meeting_time = 5,
 return 20
 
 */

import java.util.*;
import java.io.*;

public class CalenderScheduler {
    //find the first time slot that can schedule the work
    public int find (int[][] schedule1, int[][] schedule2, int required) {
        List<int[]> pos = new ArrayList<int[]>();
        int lastStart = 0;
        for (int[] job : schedule1) {
            pos.add(new int[]{job[0], 1});
            pos.add(new int[]{job[1], -1});
        }
        for (int[] job : schedule2) {
            pos.add(new int[]{job[0], 1});
            pos.add(new int[]{job[1], -1});
        }
        Collections.sort(pos, (a, b) -> {
            return a[0] - b[0];
        });
        //System.out.println(pos.size() + "size #");
        int count = 0;
        int result = 0;
        for (int i = 0; i <= pos.size(); i++) {
            if (i == pos.size()) { // can only allocate after all is done;
                result = lastStart;
                break;
            }
            int[] now = pos.get(i);
            if (count == 0) {  // no meeting ongoing
                if (now[0] - lastStart >= required) { // does the time slot > time required?
                    result = lastStart;
                    break;
                } 
            }
            if (now[1] == 1)
                count++;
            if (now[1] == -1) {  
                count--;
                if (count == 0)
                    lastStart = now[0]; // update the possible start time;
            }
        }
        System.out.println(result);
        return result;

    }

        public static void main(String[] args) {
                CalenderScheduler test = new CalenderScheduler();
                int[][] a = {{0,10}, {10, 15}, {13, 20}};
        int[][] b = {{0,5}, {27, 33}};
        int[][] c = {{0,5}, {20, 25}, {27, 33}};
        test.find(a, b, 5);
        test.find(a, c, 5);
        }
}