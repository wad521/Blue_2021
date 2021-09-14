package 力扣每日;

import java.util.Arrays;
import java.util.List;

/**
 * @author:yxl
 **/
public class 得到匹配最长串 {
    public String findLongestWord(String s, List<String> dictionary) {

        //反向dp
        //dp[i][j] 表示 从字符s的下标i开始第一个字符j的位置
        int m = s.length();
        int[][] dp = new int[m + 1][26];
        //从后往前填表
        Arrays.fill(dp[m], m);

        for (int i = m - 1; i >= 0; i++) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) == (char) ('a' + j)) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }


        String res = "";
        for (String d : dictionary) {
            boolean match = true;

            // i:从下标i开始
            // j:字符j
            int i = 0;
            for (int j = 0; j < d.length(); j++) {
                if (dp[i][d.charAt(j) - 'a'] == m) {
                    match = false;
                    break;
                }
                i = dp[i][d.charAt(j) - 'a'] + 1;
            }

            if(match){
                if(d.length()>res.length()||(d.length()==res.length() && d.compareTo(res)<0)){
                    res = d;
                }
            }
        }
        return res;
    }
}
