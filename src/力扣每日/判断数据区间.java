package 力扣每日;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:yxl
 **/
public class 判断数据区间 {
    //根据数据范围，添加两个哨兵
    List<int[]> list = new ArrayList<>();
    int[] head = new int[]{-10, -10}, tail = new int[]{10010, 10010};
    public 判断数据区间() {
        list.add(head);
        list.add(tail);
    }

    public void addNum(int val) {
        int n = list.size();
        if(n==0){
            list.add(new int[]{val,val});
            return;
        }
        int l = 0,r = n - 1;
        while (l<r){
            int mid = (l+r+1)>>1;
            if(list.get(mid)[0] <= val){
                l = mid;
            }else {
                r = mid - 1;
            }
        }

        int[] cur = new int[]{val,val};
        int[] prev = list.get(r);
        int[] next = list.get(r+1);

        //判断val的位置
        if ((prev[0] <= val && val <= prev[1]) || (next[0] <= val && val <= next[1])) {
            // pass
        } else if (prev[1] + 1 == val && val == next[0] - 1) {
            //恰好在prev和next之间，且两者连接
            prev[1] = next[1];
            list.remove(next);
        } else if (prev[1] + 1 == val) {
            prev[1] = val;
        } else if (next[0] - 1 == val) {
            next[0] = val;
        } else {
            list.add(r + 1, cur);
        }
    }

    public int[][] getIntervals() {
        int n =list.size();
        int[][] result = new int[n-2][2];
        int idx =0;
        for (int i = 1; i < n-1; i++) {
            result[idx] = list.get(i);
            idx++;
        }
        return result;
    }
}
