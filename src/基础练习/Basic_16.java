package 基础练习;

import java.util.Scanner;

public class Basic_16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        input.close();

        for (int i = a; i <= b; i++) {
            int num = i;
            if (num >= 2) {
                String s = "";
                int d = 2;
                while(num!=d){
                    if (num % d == 0) {
                        s = s + d + "*";
                        num = num / d;
                    } else {
                        d++;
                    }
                }
                s=s+d;
                System.out.println(i+"="+s);
            }else {
                System.out.println(i+"="+i);
            }
        }
    }
}
