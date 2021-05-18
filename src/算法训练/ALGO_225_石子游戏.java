package 算法训练;

import java.util.Arrays;
import java.util.Scanner;

public class ALGO_225_石子游戏 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] num = new long[n];
        for (int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        Arrays.sort(num);
        long result = 0;
        for (int i = n - 2; i >= 0; i--) {
            result += (num[i] + 1) * (num[i + 1] + 1);
            num[i] = num[i] + num[i + 1];
        }
        System.out.println(result);
    }
}
