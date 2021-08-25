package 力扣每日;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:yxl
 **/
public class 所有可能的路径 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        cur.add(0);
        dfs(n,0,graph);
        return ans;
    }

    void dfs(int n , int u , int[][] graph){
        if(u == n-1){
            //注意将cur添加进入ans时，cur为类属性，需使用new ArrayList<>（cur）;
            ans.add(new ArrayList<>(cur));
            return;
        }
        //卑微回溯
        for(int next : graph[u]){
            cur.add(next);
            dfs(n,next,graph);
            cur.remove(cur.size() -1);
        }
    }
}
