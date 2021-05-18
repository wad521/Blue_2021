package 历届真题;

/**
 * @author:yxl
 **/
public class 门牌制作 {
    public static void main(String[] args) {
        int res = 0;
        for (int i = 1; i <= 2020; i++) {
            int num =i;
            while (num > 0) {
                if (num % 10 == 2) {
                    res++;
                }
                num = num / 10;
            }
        }
        System.out.println(res);
    }
}
