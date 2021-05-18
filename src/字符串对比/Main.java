package 字符串对比;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        if(s1.length()!=s2.length()){
            System.out.println("1");
        }else if(s1.equals(s2)){
            System.out.println("2");
        }else if(s1.toUpperCase().equals(s2.toUpperCase())){
            System.out.println("3");
        }else if(!s1.toUpperCase().equals(s2.toUpperCase())){
            System.out.println("4");
        }
    }
}