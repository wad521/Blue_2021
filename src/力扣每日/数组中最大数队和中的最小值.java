package 力扣每日;

import java.util.Arrays;

/**
 * @author:yxl
 **/
public class 数组中最大数队和中的最小值 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,4,2,4,6};
        System.out.println(minPairSum(nums));
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n/2; i++) {
            res = Math.max(res,nums[i]+nums[n-1-i]);
        }
        return res;
    }

}
