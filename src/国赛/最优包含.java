package 国赛;

import java.util.Arrays;

/**
 * @author:yxl
 **/
public class 最优包含 {
    //dp[i][j]表示S串中前i个字符，包含有T串中前j个字符最少需要修改得字符个数

    //转移状态。
    //1、如果s[i]=t[j]
    // dp[i][j]=dp[i-1][j-1]
    //
    //2、如果s[i]!=t[j],忽略/修改
    //dp[i][j]=min(dp[i-1][j],dp[i-1][j-1]+1)

    private static int dp[][];

    public static void main(String[] args) {
        int num = dfs("ABCDEABCD", "XAABZ");
        //System.out.println(num);
    }


    //注意数组初始化问题。
    public static int dfs(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        System.out.println(s.length + " " + t.length);
        dp = new int[s.length + 1][t.length + 1];

        //初始化数组
        for (int i = 0; i < s.length + 1; i++) {
            Arrays.fill(dp[i], s.length);
        }
        //dp[0][0] 为 0；
        dp[0][0] = 0;
        for (int i = 1; i <= s.length; i++) {
            //每个s[i]包含T[0] 为 0；
            //dp[i][j] 中若i<j，此种情况不判断。
            dp[i][0] = 0;
            for (int j = 1; j <= t.length; j++) {
                if(i<j){
                    continue;
                }
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        for (int i = 0; i <= s.length; i++) {
            for (int j = 0; j <= t.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[s.length][t.length];
    }
}
