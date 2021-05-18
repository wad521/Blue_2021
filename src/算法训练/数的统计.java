package 算法训练;

import java.util.Scanner;

public class 数的统计 {
    public static void main(String[] args) {
        int[] num = new int[1000001];
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int s = input.nextInt();
            num[s]++;
            //num[input.nextInt()]++;
        }

        for (int i = 1; i < num.length; i++) {
            if(num[i]!=0){
                System.out.println(i+" "+num[i]);
            }
        }
    }
}
