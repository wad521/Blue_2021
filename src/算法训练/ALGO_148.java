package 算法训练;

import java.util.Scanner;

public class ALGO_148 {
    public static void main(String[] args) {
        int m=0,n=0,m1=0,n1=0;
        int a;
        Scanner scanner = new Scanner(System.in);
        m=scanner.nextInt();
        n=scanner.nextInt();
        n1=n;
        a=m%n;
        while(a!=0)
        {
            m1=n1;n1=a;a=m1%n1;
        }
        //m,n的最大公约数为：n1
//求两个数字的最小公倍数的方法为：（两个数的乘积）/（两个数字的最大公约数）；
        System.out.println(m*n/n1);
    }
}