package 算法训练;

import java.util.Arrays;
import java.util.Scanner;

public class ALGO_228_数字游戏 {
    static int N, sum;
    //是否找到结果  true : 没有    false : 有
    static boolean stat = true;
    //该位置是否有了值
    static boolean[] visit;
    //存储结果
    static int[] array;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        sum = input.nextInt();
        stat = true;
        visit = new boolean[N + 1];
        array = new int[N];
        Arrays.fill(visit, false);
        dfs(0);
    }

    public static void dfs(int step) {
        if (step == N) {
            int[] result = new int[N];
            for (int i = 0; i < N; i++) {
                result[i] = array[i];
            }
            //第0行为result值
            //第1行 ---- 第N-1行 加法求值
            //每一行只需求钱N-i个数
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < N - i; j++) {
                    result[j] = result[j] + result[j + 1];
                }
            }
            if (result[0] == sum) {
                stat = false;
                for (int i : array) {
                    System.out.print(i + " ");
                }
                return;
            } else {
                return;
            }
        }
        if (stat == true) {
            for (int i = 1; i <= N; i++) {
                if (visit[i] == false) {
                    array[step] = i;
                    visit[i] = true;
                    dfs(step + 1);
                    //保证只输出一个答案
                    if (stat == false) {
                        return;
                    }
                    //状态回归方程
                    visit[i] = false;
                }
            }
        }
        return;
    }
}
