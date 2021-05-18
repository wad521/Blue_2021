package 算法训练;

import java.util.Scanner;

public class ALGO_201 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long num = input.nextInt();
        double s1 = Math.sqrt(num);
        long s = (long) s1;
        if(s*s>=num){
            System.out.println(s*s);
        }else{
            s+=1;
            System.out.println(s*s);
        }
    }
}
