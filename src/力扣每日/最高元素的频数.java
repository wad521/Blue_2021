package 力扣每日;

import java.util.Arrays;

/**
 * @author:yxl
 **/
public class 最高元素的频数 {
    //二分+有序前缀和+窗口
    static int[] num ,sum;
    static int target , len;
    public static void main(String[] args) {
        int[] number = new int[]{9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};
        System.out.println(maxFrequency(number,3056));
    }

    /*
    * sum[i] = num[0----i-1]的前缀和
    *
    * */
    public static int maxFrequency(int[] nums, int k) {
        num = nums;
        len = nums.length;
        target = k;
        Arrays.sort(num);
        sum = new int[len+1];
        for (int i = 1; i < len+1; i++) {
            sum[i] = sum[i-1]+num[i-1];
        }
        int l=0,r=len;
        while (l<r){
            int mid = (l+r+1)>>1;
            if(check(mid))
                l = mid;
            else
                r = mid-1;
        }
        return  r;
    }

    public static boolean check(int le){
        for (int l=0;l+le-1<len;l++){
            int r = l+le-1;
            int cur = sum[r+1] - sum[l];
            int he = num[r]*le;
            if(he - cur <= target)
                return true;
        }
        return false;
    }
}
