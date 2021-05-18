package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 整商问题 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the dividend:");
        int m = input.nextInt();
        System.out.println("Please enter the divisor:");
        int n = input.nextInt();
        while(n==0){
            System.out.println("Error: divisor can not be zero! Please enter a new divisor:");
            n=input.nextInt();
        }
        System.out.println(m/n);
    }
}
