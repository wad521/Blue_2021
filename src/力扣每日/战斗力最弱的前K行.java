package 力扣每日;

import java.util.PriorityQueue;

/**
 * @author:yxl
 **/
public class 战斗力最弱的前K行 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->{
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (mat[i][mid] >= 1) l = mid;
                else r = mid - 1;
            }
            int cur = mat[i][r] >= 1 ? r + 1 : r;
            if (q.size() == k && q.peek()[0] > cur) q.poll();
            if (q.size() < k) q.add(new int[]{cur, i});
        }
        int[] ans = new int[k];
        int idx = k - 1;
        while (!q.isEmpty()) ans[idx--] = q.poll()[1];
        return ans;
    }
}
