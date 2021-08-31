package 力扣每日;

/**
 * @author:yxl
 **/
public class 航班预订统计 {
    //差分数组
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //第 ii 个数即为原数组的第 i-1i−1 个元素和第 ii 个元素的差值
        //差分数组求和可以得到原数组
        int[] nums = new int[n];
        for(int[] booking : bookings){
            int l = booking[0] -1;
            int r = booking[1];
            nums[l] += booking[2];
            //r若等于n  则代表到了末尾，不需要再末尾添加。
            if(r<n){
                nums[r] -= booking[2];
            }
        }

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
