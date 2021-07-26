package 力扣每日;

/**
 * @author:yxl
 **/
public class 最长上升子序列 {
    //tails[len] = x 表示在长len的各种情况的上升子序列中的最小结尾元素x
    //res表示当前tails长度
    //二分查找[0,res）区间内的以nums[k]为分界点

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
}
