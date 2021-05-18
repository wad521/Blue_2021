package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 求1加到x的和 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
