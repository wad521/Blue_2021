package 字节笔试题;

/**
 * @author:yxl
 **/

/*字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。
询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class 交换字符串得到最长连续字符数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String S = s.split(" ")[0];
        int m = Integer.parseInt(s.split(" ")[1]);
        char[] chs = S.toCharArray();
        int len = chs.length;

        //将每个字符的下标存储起来，然后进行动态规划。
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> list = map.getOrDefault(chs[i], new ArrayList<>());
            list.add(i);
            map.put(chs[i], list);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            int size = value.size();
            if (size == 1) { //该字母只出现过一次,就不用移动了
                res = Math.max(res, 1);
                continue;
            }
            int curMax = 1;
            // dp[i][j]代表将value[i]和value[j]包括j~i之间所有的字母连续的组合在一起所需要最少的移动次数
            int[][] dp = new int[size][size];
            for (int i = 1; i < value.size(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (j == i - 1) { //只有两个数,取距离差
                        dp[i][j] = value.get(i) - value.get(j) - 1;
                    } else {    //有多个数
                        // 除了边界两个的中间移动次数 +边界两个本来应该的移动次数 - 中间相同字母占的位数
                        //eg：0 — - -  3 5  — 6  中间3和5处的a占了两格
                        //中间的连续在一起，占有（i-j-1）个格子，剩下的位置让i与j两处的向中间靠拢
                        //若位置i x y j 此时 下标x-->y 之间全为相同字符
                        //dp[i][j] = dp[i-1][j-1] + (x - value.get(i)-1) +(value.get(j) - y -1)
                        //dp[i][j] = dp[i-1][j-1] + (value.get(i) - value.get(j) - 1) +( x-y-1)
                        //===> dp[i][j] = dp[i - 1][j + 1] + (value.get(i) - value.get(j) - 1) - (y - x + 1)
                        //(y-x-1)是 中间相同字母占的位数 等同于i - j - 1
                        dp[i][j] = dp[i - 1][j + 1] + (value.get(i) - value.get(j) - 1) - (i - j - 1);
                    }
                    curMax = dp[i][j] <= m ? Math.max(i - j + 1, curMax) : curMax;
                }
            }
            res = Math.max(curMax, res);
        }
        System.out.println(res);
    }
}