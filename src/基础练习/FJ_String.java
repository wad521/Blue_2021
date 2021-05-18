package 基础练习;

import java.util.Scanner;

public class FJ_String {
    private static String[] s = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String q = "";
        String re = deep(0, n,q);
        System.out.println(re);
    }

    private static String deep(int num, int n,String st) {
        if (num == n) {
            return st;
        }
        StringBuffer s1 = new StringBuffer();
        s1.append(st);
        s1.append(s[num]);
        s1.append(st);
        return deep(num+1,n,s1.toString());
    }
}

