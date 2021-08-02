package 力扣每日;

import java.util.Arrays;

/**
 * @author:yxl
 **/
public class 网络延迟时间_DIjkstra {
    int N = 110, M = 6010;
    int[][] w = new int[N][N];
    int[] dist = new int[N];
    boolean[] vis = new boolean[N];
    int INF = 0x3f3f3f3f;
    int n, k;
    public int networkDelayTime(int[][] ts, int _n, int _k) {
        n = _n; k = _k;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            w[u][v] = c;
        }
        dijkstra();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans > INF / 2 ? -1 : ans;
    }


    void dijkstra() {
        Arrays.fill(vis, false);
        Arrays.fill(dist, INF);
        dist[k] = 0;
        for (int p = 1; p <= n; p++) {
            int t = -1;

            //找到目前dist未被访问的节点中最小的可访问节点 为 t
            for (int i = 1; i <= n; i++) {
                if (!vis[i] && (t == -1 || dist[i] < dist[t])) t = i;
            }
            vis[t] = true;
            //从节点t开始向外扩展 。
            for (int i = 1; i <= n; i++) {
                dist[i] = Math.min(dist[i], dist[t] + w[t][i]);
            }
        }
    }
}
