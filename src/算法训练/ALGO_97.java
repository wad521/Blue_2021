package 算法训练;

import java.util.Arrays;
import java.util.Scanner;

public class ALGO_97 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i]=input.nextInt();
        }
        input.close();
        Arrays.sort(a);
        for (int i = 2; i >=0 ; i--) {
            System.out.print(a[i]+" ");
        }
    }
}
