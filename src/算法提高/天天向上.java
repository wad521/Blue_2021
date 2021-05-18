package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 天天向上 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] student = new int[n];
        for (int i = 0; i < n; i++) {
            student[i] = input.nextInt();
        }
        int[][] dp = new int[4][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (student[j] > student[i]) {
                    dp[1][j] += dp[0][i];
                    dp[2][j] += dp[1][i];
                    dp[3][j] += dp[2][i];
                }
            }
            for(int[] q :dp){
                for(int s:q){
                    System.out.print(s+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += dp[3][i];
        }
        System.out.println(sum);
    }
}
