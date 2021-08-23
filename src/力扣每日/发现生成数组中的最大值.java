package 力扣每日;

/**
 * @author:yxl
 **/
public class 发现生成数组中的最大值 {
    public int getMaximumGenerated(int n) {
        if(n==0){
            return 0;
        }
        int[] num = new int[n+1];
        num[0] = 0;
        num[1] = 1;
        for (int i = 0; i <= n ; i++) {
            if(2*i<=n){
                num[2*i] = num[i];
            }
            if(2*i+1<=n){
                num[2*i+1] = num[i] + num[i+1];
            }
        }
        int max =0;
        for (int i = 0; i <= n ; i++) {
            max = Math.max(max,num[i]);
        }
        return max;
    }
}
