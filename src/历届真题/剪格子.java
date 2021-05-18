package 历届真题;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 剪格子 {
    //存值
    private static int[][] a;
    //上下左右四个方向
    private static int[][] points = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    //访问数组
    private static boolean[][] visit;
    private static int sum = 0, m, n;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        m = input.nextInt();
        n = input.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int te = input.nextInt();
                a[i][j] = te;
                sum += te;
            }
        }
        if (sum % 2 == 1) {
            System.out.println(0);
        } else {
            visit = new boolean[n][m];
            dfs(0, 0, a[0][0], 1);
            System.out.println(result);
        }
    }

    //k表示当前选了多少个格子
    public static void dfs(int x, int y, int num, int k) {
        if (num == sum / 2) {
            result = Math.min(result, k);
        }
        for (int[] point : points) {
            int dx = x + point[0];
            int dy = y + point[1];
            if (!judge(dx, dy, num)) {
                continue;
            }
            visit[dx][dy] = true;
            dfs(dx, dy, num + a[dx][dy], k + 1);
            visit[dx][dy] = false;
        }
    }

    public static boolean judge(int x, int y, int num) {
        if (x < 0 || x > n - 1 || y < 0 || y > m - 1) {
            return false;
        }
        if (num + a[x][y] > sum / 2) {
            return false;
        }
        if (visit[x][y] == true) {
            return false;
        }
        return true;
    }
}
//3 3
//1 2 1
//3 1 2
//1 1 0