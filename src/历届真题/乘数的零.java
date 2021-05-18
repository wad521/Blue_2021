package 历届真题;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 乘数的零 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int c2 = 0, c5 = 0, c10 = 0;
        while (N > 0) {
            int num = input.nextInt();
            while (num % 10 == 0) {
                c10++;
                num /= 10;
            }
            while (num % 5 == 0) {
                c5++;
                num /= 5;
            }
            while (num % 2 == 0) {
                c2++;
                num /= 2;
            }
            N--;
        }
        System.out.println(c10 + Math.min(c2, c5));
    }
}
