import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:yxl
 **/
public class 情侣牵手 {
    public static void main(String[] args) {
        int[] num = new int[]{0,5,7,1,4,3,2,6};
        System.out.println(minSwapsCouples(num));
    }
    public static int minSwapsCouples(int[] row) {
        int n = row.length;
        int tot = n / 2;

        List<Integer>[] graph = new List[tot];
        for (int i = 0; i < tot; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i += 2) {
            int l = row[i] / 2;
            int r = row[i + 1] / 2;
            if (l != r) {
                graph[l].add(r);
                graph[r].add(l);
            }
        }
        for (List<Integer> s : graph){
            System.out.print(s);
        }
        System.out.println();
        boolean[] visited = new boolean[tot];
        int ret = 0;
        for (int i = 0; i < tot; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<Integer>();
                visited[i] = true;
                queue.offer(i);
                int cnt = 0;

                while (!queue.isEmpty()) {
                    int x = queue.poll();
                    cnt += 1;

                    for (int y : graph[x]) {
                        if (!visited[y]) {
                            visited[y] = true;
                            queue.offer(y);
                        }
                    }
                }
                ret += cnt - 1;
            }
        }
        return ret;
    }
}

