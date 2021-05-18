package 历届真题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 乘积最大_2018 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        multiplicative(num, k);
    }

    public static void multiplicative(int[] num, int k) {
        Arrays.sort(num);
        int len = num.length;
        int i = 0, j = len - 1;
        long result = 1;
        //k为奇数时
        if (k % 2 != 0) {
            result = result * num[j];
            j -= 1;
            k -= 1;
        }
        //全为负数时：
        if (result < 0) {
            while (k > 0) {
                result *= num[j];
                j--;
                k--;
            }
        }else{
            while (k > 0) {
                if (num[j] * num[j - 1] > num[i] * num[i + 1]) {
                    result *= num[j] * num[j - 1];
                    k -= 2;
                    j -= 2;
                } else {
                    result *= num[i] * num[i + 1];
                    k -= 2;
                    i += 2;
                }
            }
        }

        System.out.println(result % 1000000009);
    }
}
