package 力扣每日;

/**
 * @author:yxl
 **/
public class 优美的排列 {
    //状态压缩mask
    //state：存储情况（看做二进制）
    // f[i][state] : 前i个数，能组成方案为state的种数
    // 若 i=k,state = state;
    //需要满足 state 中的第 k 位为 1
    //k 能被 i 整除  ||  i 能被 k 整除。
    //即 上一状态的k没使用时其余位无差别的state
    // [state & ~(1<<(k-1))]
    public int countArrangement(int n) {
        int mask = 1<<n;
        int[][] f = new int[n+1][mask];
        f[0][0] =1;
        //取第i位数字
        for (int i = 1; i <= n; i++) {
            //枚举所有的状态
            for(int state =0;state<mask;state++){
                //当前状态下 枚举选过的数字为k
                for (int k = 1; k <=n ; k++) {
                    //该状态下k没选取  则不符合此状态
                    if((state>>(k-1)&1) == 0) continue;
                    //该状态下选取了 ， 但不满足条件
                    if(k%i!=0 && i%k!=0) continue;
                    //该状态下，k可选，且满足则 + 来自上一状态的种数
                    f[i][state] += f[i-1][state & ~(1<<(k-1))];
                }
            }
        }
        return f[n][mask-1];
    }



}
