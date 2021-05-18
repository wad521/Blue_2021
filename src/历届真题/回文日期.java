package 历届真题;

import java.util.*;

/**
 * @author:yxl
 **/
public class 回文日期 {

    static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String date1 = sc.next();
//        String date2 = sc.next();
        int ans = 0;
        boolean r1 = true, r2 = true;

        int y1 = Integer.parseInt(date1.substring(0, 4));
        int m1 = Integer.parseInt(date1.substring(4, 6));
        int d1 = Integer.parseInt(date1.substring(6, 8));

        while (r1 || r2) {
//            if (check(y1, m1, d1)) ans++;
//            if (y1 == y2 && m1 == m2 && d1 == d2) break;
            d1++;
            if (m1 == 2) {
                if (y1 % 400 == 0 || y1 % 4 == 0 && y1 % 100 != 0) {
                    month[m1] = 29;
                } else {
                    month[m1] = 28;
                }
            }
            if (d1 > month[m1]) {
                d1 = 1;
                m1++;
            }
            if (m1 > 12) {
                m1 = 1;
                y1++;
            }
            //找到最近的回文日期
            if (check(y1, m1, d1) && r1) {
                r1 = false;
                if (m1 < 10 && d1 >= 10) {
                    System.out.println("" + y1 + "0" + m1 + "" + d1);
                } else if (m1 >= 10 && d1 < 10) {
                    System.out.println("" + y1 + "" + m1 + "0" + d1);
                } else if (d1 < 10 && m1 < 10) {
                    System.out.println("" + y1 + "0" + m1 + "0" + d1);
                } else {
                    System.out.println("" + y1 + "" + m1 + "" + d1);
                }
            }
            if (check(y1, m1, d1) && r2 && y1 / 100 == y1 % 100 && m1 == d1) {
                r2 = false;
                if (m1 < 10 && d1 >= 10) {
                    System.out.println("" + y1 + "0" + m1 + "" + d1);
                } else if (m1 >= 10 && d1 < 10) {
                    System.out.println("" + y1 + "" + m1 + "0" + d1);
                } else if (d1 < 10 && m1 < 10) {
                    System.out.println("" + y1 + "0" + m1 + "0" + d1);
                } else {
                    System.out.println("" + y1 + "" + m1 + "" + d1);
                }
            }
        }
    }

    static boolean check(int y1, int m1, int d1) {
        String mm = "" + m1, dd = "" + d1;
        if (m1 < 10) mm = 0 + "" + m1;
        if (d1 < 10) dd = 0 + "" + d1;
        String sb1 = y1 + "" + mm + dd;
        StringBuilder sb2 = new StringBuilder(sb1);
        sb2.reverse();
        return sb1.equals(sb2.toString());
    }
}
