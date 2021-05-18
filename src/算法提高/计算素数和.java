package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 计算素数和 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = 0;
        int i = 3;
        boolean is = true;
        if (n >= 2) {
            sum += 2;
        }
        while (i <= n) {
            for (int j = 2; j <= i / 2 + 1; j++) {
                if (i % j == 0) {
                    is = false;
                    break;
                }
            }
            if (is) {
                sum += i;
            }
            is = true;
            i++;
        }
        System.out.println(sum);
    }
}
