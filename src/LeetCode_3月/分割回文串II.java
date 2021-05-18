package LeetCode_3月;

import java.util.Arrays;

/**
 * @author:yxl
 **/
public class 分割回文串II {
    public static void main(String[] args) {
        Solution_分割回文串II s1 = new Solution_分割回文串II();
        int a = s1.minCut("abbab");
        System.out.println(a);
    }
}

class Solution_分割回文串II {
    public int minCut(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        // 预处理
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        //特殊情况无法 "abbab"   正确1   上述为0
//        int idx = len - 1, res = 0;
//        while (idx >= 0) {
//            for (int i = 0; i <= idx; i++) {
//                if (dp[i][idx]) {
//                    idx = i - 1;
//                    res++;
//                    break;
//                }
//            }
//        }
//        //"adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece"
//        //无法正确
//        idx = 0;
//        int res2 = 0;
//        while (idx < len) {
//            for (int i = len - 1; i >= 0; i--) {
//                if (dp[idx][i]) {
//                    idx = i + 1;
//                    res2++;
//                    break;
//                }
//            }
//        }
//        return Math.min(res - 1, res2 - 1);


        //f[i]表示字符串s的前缀 s[0..i]的最少分割次数。
        int[] f = new int[len];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < len; ++i) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[len - 1];
    }
}
