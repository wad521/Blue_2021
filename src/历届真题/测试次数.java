package 历届真题;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 测试次数 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int N = input.nextInt();

        phone_diff(N, m);
    }

    public static void phone_diff(int N, int m) {
        //dp[i][j] 表示i个手机在第j层的最佳策略下的最坏运气的次数。
        int[][] dp = new int[m + 1][N + 1];
        //1个手机在j层的共多少种可能。
        for (int j = 1; j < N + 1; j++) {
            dp[1][j] = j;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                //从第K层开始摔
                for (int k = 1; k <= j; k++) {
                    //没摔碎
                    int num1 = 1 + dp[i][j - k];
                    //摔碎
                    int num2 = 1 + dp[i - 1][k - 1];

                    int num = Math.max(num1, num2);
                    dp[i][j] = Math.min(dp[i][j], num);
                }
            }
        }
        System.out.println(dp[m][N]);
    }
}
