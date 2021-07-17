package 剑指Offer;

/**
 * @author:yxl
 **/
public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        //dp[i]表示以num[i]结尾的连续最大值
        int[] dp = new int[len];
        int result = nums[0] ;
        dp[0]=nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
