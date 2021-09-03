package 剑指Offer;

import java.util.PriorityQueue;

/**
 * @author:yxl
 **/
public class 最小K个数 {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o1>o2?-1:1);
        int[] ans = new int[k];
        if (k == 0) return ans;
        for (int i : arr) {
            if (queue.size() == k && queue.peek() <= i) continue;
            if (queue.size() == k) queue.poll();
            queue.add(i);
        }
        for (int i = k - 1; i >= 0; i--) ans[i] = queue.poll();
        return ans;
    }
}
