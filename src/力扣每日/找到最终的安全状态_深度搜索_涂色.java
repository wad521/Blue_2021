package 力扣每日;
import java.util.*;
/**
 * @author:yxl
 **/
public class 找到最终的安全状态_深度搜索_涂色 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        //白色（用 0 表示）：该节点尚未被访问；
        //灰色（用 1 表示）：该节点位于递归栈中，或者在某个环上；
        //黑色（用 2 表示）：该节点搜索完毕，是一个安全节点。
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (safe(graph, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }
}
