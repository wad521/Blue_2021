package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 字符串顺序比较 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.next();
        String s2 = input.next();
        if(s1.compareTo(s2)>0){
            System.out.println("-1");
        }else if(s1.compareTo(s2)<0){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}
