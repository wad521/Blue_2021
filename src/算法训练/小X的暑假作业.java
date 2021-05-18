package 算法训练;

import java.util.Scanner;
//时间超时大概率
public class 小X的暑假作业 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        while (T-- > 0) {
            int N = input.nextInt();
            int P = input.nextInt();
            System.out.println(fibonac_mod(N, P));
        }
    }

    public static int fibonac_mod(int n, int p) {
        int first = 1, second = 1, third = 1;
        for (int i = 2; i <= n; i++) {
            third = (first % p) + (second % p);
            first = second;
            second = third;
        }
        return third % p;
    }
}
