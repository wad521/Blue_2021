package 历届真题;

/**
 * @author:yxl
 **/
public class 方格分割 {
    //看做xOy坐标，中心点（3,3）。
    static boolean[][] vis = new boolean[7][7];
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int cnt = 0;
    public static void main(String[] args) {
        vis[3][3] = true;
        f(3, 3);
        System.out.println(cnt/4);
    }
    private static void f(int x, int y) {
        // 边界条件
        if (x == 0 || x == 6 || y == 0 || y == 6) {
            cnt++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if (vis[dx][dy] == false) {
                vis[dx][dy] = true;
                //中心对称点  6-dx,6-dy
                //构建分界线。
                vis[6-dx][6-dy] = true;
                f(dx, dy);
                vis[6-dx][6-dy] = false;
                vis[dx][dy] = false;
            }

        }
    }
}
