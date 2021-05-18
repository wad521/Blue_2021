package 算法提高;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//dp[M][M] ； dp[i][j] 表示第i个羊在被第j个吃掉。


/**
 * @author:yxl
 **/
public class 宰羊 {
    public static void main(String[] args) {
        int t, n, m;
        int[] num = new int[100 + 2];
        int[][] dp = new int[100 + 2][100 + 2];
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();

            for (int i = 1; i <= m; i++) {
                num[i] = sc.nextInt();
            }

            num[0] = 0;
            num[m + 1] = n + 1;

            //dp[i][j] 表示第i只羊到第j只羊内所有的可杀羊全被杀。
            //eg：待杀序列 3 6 14   （待杀羊重新理解编号1、2、3）
            //dp[2][3] 表示 6、14这两只羊被杀后的最小消耗
            //dp[1][1] 表示 3 这只羊最后被杀的最小消耗
            //dp[i]j] = n ; 表示仅【i->j】之间的的羊未杀时，杀掉待宰编号i，i+1,i+2....j的代价n。
            //dp[l][r] = Math.min(dp[l][r], num[r + 1] - num[l - 1] - 2 + dp[l][i - 1] + dp[i + 1][r]);
            //上式：表示l->r中 先杀编号i，后杀l->i-1,i+1->r区间的消耗数。
            //反向递归

            for (int len = 1; len <= m; len++)
                for (int l = 1; l + len - 1 <= m; l++) {
                    int r = len + l - 1;
                    if (len == 1) {
                        dp[l][r] = num[r + 1] - num[l - 1] - 2;
                    } else {
                        dp[l][r] = 10000000;
                        for (int i = l; i <= r; i++) {
                            dp[l][r] = Math.min(dp[l][r], num[r + 1] - num[l - 1] - 2 + dp[l][i - 1] + dp[i + 1][r]);
                            System.out.println();
                            for (int q = 0; q < m + 2; q++) {
                                for (int s = 0; s < m + 2; s++) {
                                    System.out.print(dp[q][s] + "   ");
                                }
                                System.out.println();
                            }
                        }
                    }
                }
            list.add(dp[1][m]);
        }
        sc.close();
        for (int i : list) {
            System.out.println(i);
        }
    }
}
