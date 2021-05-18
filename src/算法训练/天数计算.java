package 算法训练;

import java.util.Scanner;

public class 天数计算 {
     static int[] n1 = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
     static int[] n2 = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();

        if((year%4==0&&year%100!=0)||year%400==0){
            int sum = 0;
            for (int i = 0; i < month-1; i++) {
                sum+=n2[i];
            }
            sum+=day;
            System.out.println(sum);
        }else {
            int sum = 0;
            for (int i = 0; i < month - 1; i++) {
                sum += n1[i];
            }
            sum += day;
            System.out.println(sum);
        }
    }
}
