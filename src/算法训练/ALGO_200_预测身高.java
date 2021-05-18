package 算法训练;

import java.util.Scanner;

public class ALGO_200_预测身高 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sex = input.nextInt();
        double f_heigh = input.nextDouble();
        double m_heigh = input.nextDouble();
        if(sex==1){
            double result = (f_heigh+m_heigh)/2*1.08;
            System.out.printf("%.3f",result);
        }else{
            double result = ((f_heigh*0.923)+m_heigh)/2;
            System.out.printf("%.3f",result);
        }
    }
}
