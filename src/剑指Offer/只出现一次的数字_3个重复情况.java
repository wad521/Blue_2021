package 剑指Offer;

/**
 * @author:yxl
 **/
public class 只出现一次的数字_3个重复情况 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,1,2,3};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int ans =0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for(int num : nums){
                //存储第i位有多少个1
                sum += ((num >>i )& 1);
            }
            //如果对3求余后的数 为只出现一次的数字的 i位
            sum = sum%3;
            ans +=(sum<<i);
        }
        return ans;
    }
}
