package 基础练习;

import java.util.Scanner;

public class Sine_Wu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String re = An(1, n,"");
        System.out.println(re);
    }

    private static String Sn(int num, int n,String s) {
        StringBuffer qt = new StringBuffer();
        if (num == n) {
            qt.append(s);
            qt.append(An(1, num,"") + "+" + (n - num + 1) + "");
            return qt.toString();
        }
        qt.append("("+s);
        qt.append(An(1, num,"") + "+" + (n - num + 1) + ")");
        return Sn(num+1,n,qt.toString());
    }

    private static String An(int num, int n,String s) {
        StringBuffer st = new StringBuffer();
        if (num >= n + 1) {
            return s;
        }
        if (num == 1) {
            st.append(s+"sin(" + num + "");
        } else if (num % 2 == 0) {
            st.append(s+"-sin(" + num + "");
        } else if (num % 2 != 0) {
            st.append(s+"+sin(" + num + "");
        }
        return An(num+1,n,st.toString())+")";
    }
    //private static String An(int num, int n) {
    //        if (num >= n + 1) {
    //            return "";
    //        }
    //        StringBuffer st = new StringBuffer();
    //        if (num == 1) {
    //            st.append("sin(" + num + "");
    //            st.append(An(num + 1, n));
    //            st.append(")");
    //        } else if (num % 2 == 0) {
    //            st.append("-sin(" + num + "");
    //            st.append(An(num + 1, n));
    //            st.append(")");
    //        } else if (num % 2 != 0) {
    //            st.append("+sin(" + num + "");
    //            st.append(An(num + 1, n));
    //            st.append(")");
    //        }
    //        return st.toString();
    //    }
}
