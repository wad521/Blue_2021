package 历届真题;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class k倍区间 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] sum = new int[n + 1];
        long count = 0L;
        int[] num = new int[k];
        num[0] = 1;
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            int x = input.nextInt();
            sum[i] = (sum[i - 1] + x) % k;
            num[sum[i]]++;
        }
        for (int i = 0; i < k; i++) {
            count += (long) num[i] * (num[i] - 1) / 2;
        }
        System.out.println(count);
    }
}
