package 力扣每日;

/**
 * @author:yxl
 **/
public class 按权重随机分配 {
    int[] sum;
    public 按权重随机分配(int[] w) {
        int n = w.length;
        sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + w[i-1];
        }
    }

    public int pickIndex() {
        int n = sum.length;
        //大于左；小于等于右
        int t = (int)(Math.random()*sum[n-1] +1);
        int l =1,r = n-1;
        while (l<r){
            int mid = (l+r)>>1;
            if(sum[mid] >= t){
                r = mid;
            }else {
                l = mid + 1 ;
            }
        }

        //最终的index是sum[r]所处的区间  即 第 r - 1 个数
        return r -1;
    }
}
