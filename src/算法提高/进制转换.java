package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 进制转换 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n!=0){
            System.out.println("0"+Integer.toOctalString(n));
        }else{
            System.out.println(Integer.toOctalString(n));
        }

    }
}
