package LeetCode_3月;

/**
 * @author:yxl
 **/
public class 不同的子序列 {
    public int numDistinct(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();
        //dp[m][n] 对应于从 S[m，S_len) 中能选出多少个 T[n，T_len)。
        int[][] dp = new int[s_len + 1][t_len + 1];
        //当T为空串时，所有的 s 对应于 1
        for (int i = 0; i <= s_len; i++) {
            dp[i][t_len] = 1;
        }
        //倒着进行，T 每次增加一个字母
        for (int t_i = t_len - 1; t_i >= 0; t_i --) {
            //倒着进行，S 每次增加一个字母
            for (int s_i = s_len - 1; s_i >= 0; s_i--) {
                if (s.charAt(s_i) == t.charAt(t_i)) {
                    dp[s_i][t_i] = dp[s_i + 1][t_i + 1] + dp[s_i + 1][t_i];
                } else {
                    dp[s_i][t_i] = dp[s_i + 1][t_i];
                }
            }
        }
        return dp[0][0];
    }
}
