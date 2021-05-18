package 算法训练;

import java.util.Scanner;

public class ALGO_79 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        int result = CompactIntegers(num, n);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(num[i]+" ");
        }
    }

    public static int CompactIntegers(int[] num, int n) {
        int re = n;
        for (int i = 0; i < re; i++) {
            while (num[i] == 0) {
                for (int j = i; j < re-1; j++) {
                    num[j] = num[j + 1];
                }
                re--;
                if (re<=i){
                    break;
                }
            }
        }
        return re;
    }
}
