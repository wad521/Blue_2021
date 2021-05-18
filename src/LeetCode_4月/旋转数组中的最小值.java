package LeetCode_4月;

/**
 * @author:yxl
 **/
public class 旋转数组中的最小值 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        if (len == 1) {
            return nums[0];
        }

        while (l < r) {
            int mid = (l + r + 1) / 2;
            //mid位于前半部分
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return r + 1 < len ? nums[r + 1] : nums[0];
    }
}
