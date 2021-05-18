package 基础练习;

import java.util.Scanner;

public class XinPianCeShi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[j] += input.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            if (num[i] > n / 2) {
                System.out.print(i+1+" ");
            }
        }
    }
}
