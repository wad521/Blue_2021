package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 分割项链 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] wi = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            wi[i] = input.nextInt();
        }
        //dp[i]表示前i个珍珠的重量和
        dp[0] = wi[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + wi[i];
        }
        int sum = dp[n - 1];
        //两盗贼之间珍珠重量的最小差值
        int min = Integer.MAX_VALUE;
        //甲盗贼的珍珠重量
        int l;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i + j;
                //从i到n-1的重量和 + 0到(i + j) % n的重量和
                if (idx >= n) {
                    l = dp[n - 1] - dp[i - 1] + dp[idx % n];
                } else if (j == 0) {
                    l = wi[i];
                } else if (i == 0) {
                    l = dp[j];
                } else {
                    l = dp[idx % n] - dp[i - 1];
                }
                min = Math.min(min, Math.abs(sum - 2 * l));
            }
        }
        System.out.println((sum - min) / 2);
    }
}
