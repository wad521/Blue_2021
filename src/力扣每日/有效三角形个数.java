package 力扣每日;

import java.util.Arrays;

/**
 * @author:yxl
 **/
public class 有效三角形个数 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,4};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        int n = nums.length;
        int ans =0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int l = 0, r = j - 1;
                while (l<r){
                     int mid = (l+r)>>1;
                     if(nums[mid]+nums[j]>nums[i]){
                         r=mid;
                     }else{
                         l = mid+1;
                     }
                }

                if(l==r && nums[r]+nums[j]>nums[i]){
                    ans = ans +(j-r);
                }
            }
        }
        return ans;
    }
}
