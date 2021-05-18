package 历届真题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 错误票据 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[10000];
        int count = 0;
        input.nextLine();
        for (int i = 0; i < n; i++) {
            Scanner sc = new Scanner(input.nextLine());
            while (sc.hasNext()) {
                int s = sc.nextInt();
                num[count++] = s;
                //System.out.println(s);
            }
        }
        Arrays.sort(num, 0, count);

        for (int i = 0; i < count; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
        int M = 0, N = 0;
        for (int i = 0; i < count; i++) {
            if (num[i] == num[i + 1] - 2) {
                M = num[i] + 1;
            }

            if (num[i] == num[i + 1]) {
                N = num[i];
            }
        }
        System.out.println(M + " " + N);
    }
}
