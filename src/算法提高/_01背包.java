package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class _01背包 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        for(int i=1; i<=N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        System.out.println(cal(N, V, w, v));
    }

    /**
     * 求01背包的解
     * @param n 物品个数
     * @param v 背包总容量
     * @param w 每个物品的价值，注意下标从1开始
     * @param c 每个物品的体积，注意下标从1开始
     * @return
     */
    private static int cal(int n, int v, int[] w, int[] c) {
        if (n == 0 || v == 0) return 0;
        if (w == null || w.length == 0) return 0;
        if (c == null || c.length == 0) return 0;

        //f[i][j],表示前i件物品放入容量为j的背包的最大价值
        int[][] f = new int[n + 1][v + 1];
        for(int i=1; i<=n; i++) {
            for(int j=1;j<=v;j++) {
                f[i][j] = j<c[i]? f[i-1][j] : Math.max(f[i-1][j], f[i-1][j-c[i]] + w[i]);
                //System.out.print(f[i][j]+" ");
            }
            //System.out.println();
        }

        return f[n][v];
    }
}
