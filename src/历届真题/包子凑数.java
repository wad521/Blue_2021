package 历届真题;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 包子凑数 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //输入包子的个数
        int N = input.nextInt();
        int[] baozi = new int[N];
        //输入每笼包子的个数Ai.
        for (int i = 0; i < N; i++) {
            baozi[i] = input.nextInt();
        }
        int g = baozi[0];
        for (int i = 1; i < N; i++) {
            g = gcd(g, baozi[i]);
        }
        if (g != 1) {
            System.out.println("INF");
        } else {
            //dp[i]表示 第i个包子数能否凑出来。
            int[] dp = new int[10001];
            //0个包子肯定能凑出来。
            dp[0] = 1;
            //以每一种包子为一次循环
            for (int i = 0; i < N; i++) {
                //从0开始判断当前数j是否可得出，并由此推出后序的j+baozi[i]可成立。
                for (int j = 0; j + baozi[i] < dp.length; j++) {
                    if (dp[j] == 1) {
                        dp[j + baozi[i]] = 1;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }


    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
