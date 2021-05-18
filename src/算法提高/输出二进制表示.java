package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 输出二进制表示 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0;i < 8;i++) {
            //System.out.println(n >> (7 - i));
            int x = n >> (7 - i) & 1;
            System.out.print(x);
        }
    }
}
