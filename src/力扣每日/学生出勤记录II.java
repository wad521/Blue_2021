package 力扣每日;

/**
 * @author:yxl
 **/
public class 学生出勤记录II {
    public static void main(String[] args) {
        System.out.println(checkRecord(10101));
    }


    public static int checkRecord(int n) {
        final int mod = 1000000007;
        //dp[i][j][k]:前i天有j个‘A’且末尾连续k个'L'
        int[][][] dp = new int[n+1][2][3];
        //初始化
        dp[0][0][0] = 1;

        for (int i = 1; i <= n ; i++) {
            //以’P‘结尾
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2 ; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) %mod;
                }
            }

            //以'A’结尾
            for (int k = 0; k <= 2 ; k++) {
                    dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k]) % mod;
            }

            //以'L'结尾
            for (int j = 0; j <= 1 ; j++) {
                for (int k = 1; k <= 2 ; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1]) % mod;
                }
            }
        }

        int sum =0;
        for (int j = 0; j <= 1 ; j++) {
            for (int k = 0; k <= 2 ; k++) {
                sum = (sum + dp[n][j][k]) % mod;
            }
        }
        return sum;
    }
}
