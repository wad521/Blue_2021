package 力扣每日;

/**
 * @author:yxl
 **/
public class 两个字符串的删除操作 {
    public int minDistance(String s1, String s2) {
        char[] cs1 = s1.toCharArray(),cs2 = s2.toCharArray();
        int n =s1.length(),m = s2.length();
        //s1的前i个字符和s2的前j个字符构成相同串是最小的删除次数；
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m ; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=m ; j++) {

                if(cs1[i]==cs2[j]){
                    dp[i][j] = dp[i-1][j-1] ;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1] ) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
