package 力扣每日;

/**
 * @author:yxl
 **/
public class 所有奇数子数组的和 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n+1];
        int ans =0;
        //前缀和数组  sum[i] ： arr前i的和
        for (int i = 1; i <= n ; i++) {
            sum[i] = sum[i-1] + arr[i-1];
        }

        //子数组长度
        for(int len =1;len <= n;len+=2){
            //arr数组的下标在【0，n-1】  所以l在【0，n-1】
            for(int l=0;l+len-1<n;l++){
                int r = l+len-1;
                ans+=sum[r+1] - sum[l];
            }
        }
        return ans;
    }
}
