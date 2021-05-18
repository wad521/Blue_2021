package 历届真题;

/**
 * @author:yxl
 **/
public class 既约分数 {
    public static void main(String[] args) {
        int res =0;
        for (int i = 1; i <= 2020; i++) {
            for (int j = 1; j <= 2020; j++) {
                if(gcd(i,j)==1){
                   res++;
                }
            }
        }
        System.out.println(res);
    }


    //求最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static long check(long a, long b) {
        while (a != b) {
            // 保证 a > b
            if (a < b) {
                long temp = a;
                a = b;
                b = temp;
            }
            long temp = a / b;
            a = b;
            b = temp;
        }
        return a;
    }
}
