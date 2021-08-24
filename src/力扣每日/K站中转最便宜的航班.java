package 力扣每日;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:yxl
 **/
public class K站中转最便宜的航班 {
    class Edge{
        //x : 起点  y : 终点   w: 价格
        int x , y ,w;
        Edge(int _x,int _y,int _w){
            x = _x;
            y = _y;
            w = _w;
        }
    }

    int N =110,INF = 0x3f3f3f3f;
    int[] dist = new int[N];
    List<Edge> list = new ArrayList<>();
    int n,m,s,d,k;

    public int findCheapestPrice(int _n, int[][] flights, int src, int dst, int _k) {
        n = _n;
        s = src;
        d = dst;
        k = _k + 1;
        //添加边
        for(int[] f : flights){
            list.add(new Edge(f[0],f[1],f[2]));
        }
        m = list.size();
        int ans = Bellman_Ford();
        return ans > INF/2 ? -1 : ans;
    }

    public int Bellman_Ford(){
        Arrays.fill(dist,INF);
        //起始点
        dist[s] = 0;

        //中转次数
        for (int i = 0; i < k; i++) {
            //dist在一直变化 ，需要使用clone数组
            int[] clone = dist.clone();
            //中转边  起点 ->y  ||  起点 - >x ->y  取最小
            for (Edge edge : list){
                int x = edge.x , y =edge.y, w = edge.w;
                dist[y] = Math.min(dist[y],clone[x]+w);
            }
        }
        return dist[d];
    }
}
