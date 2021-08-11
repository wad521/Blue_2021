package 力扣每日;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:yxl
 **/
public class 等差子序列 {
    public static void main(String[] args) {

    }

    public int numberOfArithmeticSlices(int[] nums) {
        int ans =0;
        int n = nums.length;
        //f[i]表示以nums[i]结尾的子序列中<公差d，长度l + 1 >
        Map<Long,Integer>[] f = new Map[n];

        for (int i = 0; i < n; i++) {
            f[i] = new HashMap<Long,Integer>();
        }

        //j<i保证不会重复
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d,0);
                ans+=cnt;
                f[i].put(d,f[j].getOrDefault(d,0)+cnt+1);
            }
        }
        return ans;
    }
}
