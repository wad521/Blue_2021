package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 身份证号码升级 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String []a = new String[18];
        for (int i =0 ;i<6;i++){
            a[i] = s.substring(i,i+1);
        }
        a[6] = "1";
        a[7] = "9";
        for (int i = 8;i<17;i++){
            a[i] = s.substring(i-2,i-1);
        }
        int x = (Integer.parseInt(a[0])*7+Integer.parseInt(a[1])*9
                +Integer.parseInt(a[2])*10+Integer.parseInt(a[3])*5
                +Integer.parseInt(a[4])*8+Integer.parseInt(a[5])*4
                +Integer.parseInt(a[6])*2+Integer.parseInt(a[7])*1
                +Integer.parseInt(a[8])*6+Integer.parseInt(a[9])*3
                +Integer.parseInt(a[10])*7+Integer.parseInt(a[11])*9
                +Integer.parseInt(a[12])*10+Integer.parseInt(a[13])*5
                +Integer.parseInt(a[14])*8+Integer.parseInt(a[15])*4
                +Integer.parseInt(a[16])*2)%11;
        switch (x){
            case 0:
                a[17] = "1";
                break;
            case 1:
                a[17] = "0";
                break;
            case 2:
                a[17] = "x";
                break;
            case 3:
                a[17] = "9";
                break;
            case 4:
                a[17] = "8";
                break;
            case 5:
                a[17] = "7";
                break;
            case 6:
                a[17] = "6";
                break;
            case 7:
                a[17] = "5";
                break;
            case 8:
                a[17] = "4";
                break;
            case 9:
                a[17] = "3";
                break;
            case 10:
                a[17] = "2";
                break;
        }
        for (int i =0;i<18;i++){
            System.out.print(a[i]);
        }
    }
}
