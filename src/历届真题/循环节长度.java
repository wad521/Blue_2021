package 历届真题;

import java.util.Vector;

/**
 * @author:yxl
 **/
public class 循环节长度 {
    public static void main(String[] args) {
        System.out.println(f(17,16));
    }

    public static int f(int n, int m) {
        n = n % m;
        Vector v = new Vector();

        for (; ; ) {
            System.out.println(n);
            v.add(n);
            n *= 10;
            n = n % m;
            if (n == 0) return 0;
            if (v.indexOf(n) >= 0) {
                return v.size() - v.indexOf(n);
            }
        }

    }
}