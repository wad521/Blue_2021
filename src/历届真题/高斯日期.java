package 历届真题;

import java.time.LocalDate;

/**
 * @author:yxl
 **/
public class 高斯日期 {
    public static void main(String[] args) {
        LocalDate a = LocalDate.of(1777, 4, 30);
        a = a.plusDays(0);
        LocalDate b = LocalDate.of(1777,5,1);
        System.out.println(a.until(b).getDays());
        System.out.println(a);
    }
}
