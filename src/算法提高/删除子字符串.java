package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 删除子字符串 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.next();
        String s2 = input.next();
        String[] result = s1.split(s2);
        for(String i : result){
            System.out.print(i);
        }
    }
}
