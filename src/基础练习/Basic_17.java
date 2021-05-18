package 基础练习;

import java.util.Arrays;
import java.util.Scanner;

public class Basic_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] re = new int[n][n];
        int[][] rt = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                re[i][j] = input.nextInt();
            }
        }
        if(m>0){
            rt = re;
            for (int i = 2; i <= m; i++) {
                rt = Cheng_J(rt,re);
            }
        }else if(m==0){
            for (int i = 0; i < n; i++) {
                rt[i][i]=1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rt[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] Cheng_J(int[][] rt,int[][] re) {
        int len = re.length;
        int[][] num = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    num[i][j] += (rt[i][k] * re[k][j]);
                }
            }
        }
        return num;
    }
}
