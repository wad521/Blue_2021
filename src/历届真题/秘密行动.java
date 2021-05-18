package 历届真题;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 秘密行动 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
        }
        //dp[0][i] 未使用技能到第i层
        //dp[1][i] 使用技能到第i层
        int[][] dp = new int[2][n + 1];
        dp[0][0] = 0;
        dp[1][0] = dp[1][1] = 0;
        for (int i = 1; i <= n; i++) {
            dp[0][i]=Math.min(dp[0][i-1],dp[1][i-1])+a[i];
            if(i>1){
                dp[1][i]=Math.min(dp[0][i-1],dp[0][i-2]);
            }
        }
        System.out.println(Math.min(dp[0][n],dp[1][n]));
    }
}
