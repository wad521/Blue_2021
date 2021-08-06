package 力扣每日;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:yxl
 **/
public class 访问所有节点的最短路径_状态压缩 {
    public int shortestPathLength(int[][] graph) {
        int n= graph.length;
        //初始队列，存入起点、标记状态、距离
        Queue<int[]> queue = new LinkedList<int[]>();
        //当前节点编号、状态
        //1<<n  表示有2n种状态
        boolean[][] vis = new boolean[n][1<<n];
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{i,1<<i,0}); //dix:（起点）当前节点编号  mask:状态  dist:距离
            vis[i][1<<i] =true;
        }

        //开始搜索
        while (!queue.isEmpty()){
            int[] pule = queue.poll();
            int idx = pule[0];
            int mask = pule[1];
            int dist = pule[2];

            //找到最短距离，返回结果
            if(mask == (1<<n)-1){
                return dist;
            }

            //开始bfs扩展搜索
            for(int x : graph[idx]){
                int next_mask = (mask | (1<<x));
                if(!vis[x][next_mask]){
                    queue.add(new int[]{x,next_mask,dist+1});
                    vis[x][next_mask] = true;
                }
            }
        }
        return 0;
    }
}
