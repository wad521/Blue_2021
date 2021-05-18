package 历届真题;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author:yxl
 **/
public class 日期问题 {
    //TreeSet：确保集合元素处于排序状态
    public static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        String[] s = str.split("/");
        f(s[0], s[1], s[2]);
        f(s[2], s[0], s[1]);
        f(s[2], s[1], s[0]);
        for (Integer i : set) {
            String s1 = i.toString();
            System.out.println(s1.substring(0, 4) + "-" + s1.substring(4, 6) + "-" + s1.substring(6, 8));
        }
    }

    public static void f(String year, String month, String day) {
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        if (y <= 59) {
            y += 2000;
        } else {
            y += 1900;
        }
        //选择+month+day则避免了0的缺失。
        //闰年的2月
        if (((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) && m == 2 && d <= 29 && d > 0) {
            set.add(Integer.parseInt("" + y + month + day));
        }
        //普通年的二月
        if (y % 4 != 0 && m == 2 && d > 0 && d <= 28) {
            set.add(Integer.parseInt("" + y + month + day));
        }
        //非2月,大月
        if ((m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) && d > 0 & d <= 31) {
            set.add(Integer.parseInt("" + y + month + day));
        }
        //非2月,小月
        if ((m == 4 || m == 6 || m == 9 || m == 11) && d > 0 & d <= 30) {
            set.add(Integer.parseInt("" + y + month + day));
        }
    }
}
