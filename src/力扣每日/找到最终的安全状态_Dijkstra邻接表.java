package 力扣每日;
import java.util.*;
/**
 * @author:yxl
 **/
public class 找到最终的安全状态_Dijkstra邻接表 {
    static int N = (int)1e4+10, M = 4 * N;
    static int idx;
// he 数组：存储是某个节点所对应的边的集合（链表）的头结点；
// e 数组：由于访问某一条边指向的节点；
// ne 数组：由于是以链表的形式进行存边，该数组就是用于找到下一条边；
// w 数组：用于记录某条边的权重为多少。
// 因此当我们想要遍历所有由 a 点发出的边时，可以使用如下方式：
// for (int i = he[a]; i != -1; i = ne[i]) {
//     int b = e[i], c = w[i]; // 存在由 a 指向 b 的边，权重为 c
// }

    static int[] he = new int[N], e = new int[M], ne = new int[M];
    static int[] cnts = new int[N];

    public static void main(String[] args) {
        int[][] g = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        eventualSafeNodes(g);
    }


    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        System.out.print("e["+idx+"] ="+ b +"    ne["+idx+"]="+he[a]);
        he[a] = idx++;
        System.out.println("      he["+a+"]="+he[a]);
    }
    public static List<Integer> eventualSafeNodes(int[][] g) {
        int n = g.length;
        // 存反向图，并统计入度
        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++) {
            for (int j : g[i]) {
                add(j, i);
                cnts[i]++;
            }
        }
        // BFS 求反向图拓扑排序
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0) d.addLast(i);
        }
        while (!d.isEmpty()) {
            int poll = d.pollFirst();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--cnts[j] == 0) d.addLast(j);
            }
        }
        // 遍历答案：如果某个节点出现在拓扑序列，说明其进入过队列，说明其入度为 0
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0) ans.add(i);
        }
        return ans;
    }
}
