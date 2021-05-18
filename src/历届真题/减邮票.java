package 历届真题;
//标准答案116

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author:yxl
 **/
public class 减邮票 {
    static int a[] = new int[5];
    static int ants = 0;
    static Set<HashSet<Integer>> set = new HashSet<HashSet<Integer>>();
    static boolean used[] = new boolean[13];

    /**
     * 超级集合Set用于判重
     *
     * @param args
     */
    public static void main(String[] args) {
        Arrays.fill(used, false);
        dfs(0);
        System.out.println(set.size());
    }

    //判断x,y是否相邻
    public static boolean adj(int x, int y) {
        if (x > y) {
            int t = x;
            x = y;
            y = t;
        }
        if (y - x == 4 || (y - x == 1 && x % 4 != 0)) return true;
        return false;
    }

    //判断a[0]-a[x-1]中是否有元素与i相邻
    public static boolean check(int x, int i) {
        if (x == 0) return true;
        for (int k = 0; k < x; k++) {
            if (adj(a[k], i)) return true;
        }
        return false;
    }

    public static void dfs(int x) {
        if (x == 5) {
            HashSet<Integer> s = new HashSet<Integer>();
            for (int k = 0; k < 5; k++) {
                s.add(a[k]);
            }
            //将当前数组装换成集合加入到超级集合中，最后超级集合的大小就是不重复的满足条件的结果个数
            set.add(s);
            return;
        }
        for (int i = 1; i <= 12; i++) {
            if (!used[i] && check(x, i)) {//数字i没被用过并且i还有a[0]-a[x-1]中某个数相邻
                a[x] = i;
                used[i] = true;
                dfs(x + 1);
                used[i] = false;
            }
        }
    }






    //此搜索按照下一个点的四周确定确定。无法出现2-1-3-4-8 这个序列。
//    static int a[] = new int[5];
//    static int result = 0;
//    //上右下左
//    static int[][] point = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//
//    public static void main(String[] args) {
//        boolean[][] visit = new boolean[3][4];
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 4; j++) {
//                dfs(i, j, 0, visit);
//            }
//        }
//        System.out.println(result);
//    }
//
//    public static void dfs(int x, int y, int count, boolean[][] visit) {
//        if (count == 5) {
//            result++;
//            if (result % 4 == 1) {
//                for (int i = 0; i < 5; i++) {
//                    System.out.print(a[i] + " ");
//                }
//                System.out.println();
//            }
//            return;
//        }
//        if (check(x, y)) {
//            if (!visit[x][y]) {
//                a[count] = 4 * x + y + 1;
//                visit[x][y] = true;
//                for (int i = 0; i < 4; i++) {
//                    int x1 = x + point[i][0];
//                    int y1 = y + point[i][1];
//                    dfs(x1, y1, count + 1, visit);
//                }
//                visit[x][y] = false;
//            }
//        }
//    }
//
//    //是否在界内。
//    public static boolean check(int x, int y) {
//        if (x >= 0 && x < 3 && y >= 0 && y < 4) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
