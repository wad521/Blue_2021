package 国赛;

import java.util.List;

/**
 * @author:yxl
 **/
public class 路径计数 {
    public static boolean[][] visit = new boolean[6][6];
    public static int ans = 0;
    public static int[][] points = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        dfs(0,0,0);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int step) {
        if (step > 12) {
            return;
        }

        //最少的步数为四步
        if (step >= 4 && x == 0 && y == 0) {
            ans++;
            return;
        }

        for (int[] point : points) {
            int dx = x + point[0];
            int dy = y + point[1];
            if (dx >= 0 && dx <= 5 && dy >= 0 && dy <= 5 && !visit[dx][dy]) {
                visit[dx][dy] = true;
                dfs(dx, dy, step + 1);
                visit[dx][dy] = false;
            }
        }
    }
}
