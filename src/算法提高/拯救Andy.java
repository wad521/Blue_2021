package 算法提高;

import javax.xml.stream.FactoryConfigurationError;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 拯救Andy {
    //当前点可前进的方向
    static int[][] points = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    //地图
    static int[][] map;
    //绿洲坐标(从每一个绿洲坐标遍历一次）
    static List<int[]> water;
    static int n;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int m = input.nextInt();
        int p = input.nextInt();
        map = new int[n][n];
        for (int[] s : map) {
            Arrays.fill(s, 9000001);
        }
        //毒蛇
        for (int i = 0; i < m; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            map[x - 1][y - 1] = -1;
        }
        water = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            int[] w = new int[2];
            w[0] = input.nextInt() - 1;
            w[1] = input.nextInt() - 1;
            //绿洲本处设为0。
            map[w[0]][w[1]] = 0;
            water.add(w);
        }
        help(0);
        //打印map
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //i表示遍历的第i个绿洲
    public static void help(int i) {
        while (i < water.size()) {
            //获取绿洲坐标
            int[] w = water.get(i);
            //是否全部遍历
            boolean[] visit = new boolean[n * n];
            Arrays.fill(visit, false);
            dfs(w[0], w[1], visit, w[0], w[1]);
            i++;
        }
    }

    //x,y代表现在遍历的点，n,m代表上一个点

    //遇到问题：visit需要多次清空，无法确定。
    public static void dfs(int x, int y, boolean[] visit, int n, int m) {
        int si = size(x, y);
        //未遍历过
        if (visit[si] == true) {
            return;
        }
        visit[si] = true;
        //不为毒蛇
        if (map[x][y] == -1) {
            return;
        } else {
            map[x][y] = Math.min(map[x][y], map[n][m] + 1);
            for (int[] point : points) {
                int x1 = x + point[0];
                int y1 = y + point[1];
                //未超界
                if (pd(x1, y1)) {
                    dfs(x1, y1, visit, x, y);
                    visit[si] = false;
                }
            }
        }
    }

    //是否超界
    public static boolean pd(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return true;
        } else {
            return false;
        }
    }

    public static int size(int x, int y) {
        return x * n + y;
    }
}
