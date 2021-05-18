package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 递归输出 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        show(n);
    }

    public static void show(int n) {
        if (n /10 > 0) {
            show(n / 10);
        }
        System.out.print(n % 10 + "-");
    }
}
