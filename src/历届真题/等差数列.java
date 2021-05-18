package 历届真题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 等差数列 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        Arrays.sort(num);


        //差的合集
        int[] cha = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            cha[i] = num[i + 1] - num[i];
        }

        //最大公差
        int f = cha[0];
        for (int i = 1; i < n - 1; i++) {
            f = gcd(f, cha[i]);
        }


        //根据等差数列项数规律
        int ans = (num[n - 1] - num[0]) / f + 1;
        System.out.println(ans-num.length);
    }


    //最大公约数
    public static int gcd(int m, int n) {
        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        if (m % n == 0) {// 若余数为0,返回最大公约数
            return n;
        } else { // 否则,进行递归,把n赋给m,把余数赋给n
            return gcd(n, m % n);
        }
    }


    //最小公倍数 = （m*n)/最大公约数
}
