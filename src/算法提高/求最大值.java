package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 求最大值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[222222];
        for (int i = 0; i <= 200000; i++) dp[i] = -Integer.MAX_VALUE;
        dp[100000] = 0;
        int ans=0;
        int i,j;
        for(i=0;i<n;i++) {
            int x,y;
            x = sc.nextInt();
            y = sc.nextInt();
            if(x>=0) {//背包重量为非负时
                for(j=200000;j>=x;j--) {
                    if(dp[j-x] > -Integer.MAX_VALUE) {
                        dp[j] = Math.max(dp[j], dp[j-x]+y);
                    }
                }
            }
            else {//背包重量为负时
                for(j=0;j<=200000+x;j++) {
                    if(dp[j-x]>-Integer.MAX_VALUE) {
                        dp[j] = Math.max(dp[j], dp[j-x]+y);
                    }
                }
            }
        }
        for(i=100000;i<=200000;i++) {
            if(dp[i]>=0) {
                ans = Math.max(ans, i-100000+dp[i]);
            }
        }
        System.out.print(ans);
    }
}
