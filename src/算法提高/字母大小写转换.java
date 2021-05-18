package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 字母大小写转换 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        char ch = s.charAt(0);
        if(ch>='a'&&ch<='z'){
            System.out.println((char)(ch-32));
        }
        else if(ch>='A'&&ch<='Z'){
            System.out.println((char)(ch+32));
        }else {
            System.out.println(ch);
        }
    }
}
