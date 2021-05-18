package LeetCode_3月;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author:yxl
 **/
public class 分割回文串 {
    public static void main(String[] args) {
        Solution_分割回文串 s1 = new Solution_分割回文串();
        List<List<String>> result = s1.partition("aabaab");
        for (List<String> q : result) {
            System.out.println(q);
        }
    }
}

class Solution_分割回文串 {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
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

        for (boolean[] qq: dp){
            for(boolean q :qq){
                System.out.print(q+" ");
            }
            System.out.println();
        }

        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, len, dp, stack, res);
        return res;
    }

    private void dfs(String s, int index, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            if (dp[index][i]) {
                path.addLast(s.substring(index, i + 1));
                dfs(s, i + 1, len, dp, path, res);
                path.removeLast();
            }
        }
    }
}

//
//class Solution_分割回文串 {
//    public List<List<String>> partition(String s) {
//        int len = s.length();
//        List<List<String>> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//
//        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
//        // 注意：只使用 stack 相关的接口
//        Deque<String> stack = new ArrayDeque<>();
//        char[] charArray = s.toCharArray();
//        dfs(charArray, 0, len, stack, res);
//        return res;
//    }
//
//    /**
//     * @param charArray
//     * @param index     起始字符的索引
//     * @param len       字符串 s 的长度，可以设置为全局变量
//     * @param path      记录从根结点到叶子结点的路径
//     * @param res       记录所有的结果
//     */
//    private void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
//        if (index == len) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = index; i < len; i++) {
//            if (!checkPalindrome(charArray, index, i)) {
//                continue;
//            }
//            path.addLast(new String(charArray, index, i - index + 1));
//            dfs(charArray, i + 1, len, path, res);
//            path.removeLast();
//
//        }
//    }
//
//    /**
//     * 这一步的时间复杂度是 O(N)，优化的解法是，先采用动态规划，把回文子串的结果记录在一个表格里
//     *
//     * @param charArray
//     * @param left      子串的左边界，可以取到
//     * @param right     子串的右边界，可以取到
//     * @return
//     */
//    private boolean checkPalindrome(char[] charArray, int left, int right) {
//        while (left < right) {
//            if (charArray[left] != charArray[right]) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
//}