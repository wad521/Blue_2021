package 历届真题;

import java.math.BigDecimal;

/**
 * @author:yxl
 **/
public class 数列求和 {
    public static void main(String[] args) {
        int a = 1, b = 1, c = 1;
        int result = 0;
        for (int i = 4; i <= 20190324; i++) {
            //直接保留后四位，进位直接不看
            result = (a + b + c) % 10000;
            a = b;
            b = c;
            c = result;
        }
        System.out.println(result);
    }
}
