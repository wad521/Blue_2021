package 历届真题;

/**
 * @author:yxl
 **/
public class 煤球数目 {
    public static void main(String[] args) {
        int result =0;
        int sum=0;
        for (int i = 1; i <=100 ; i++) {
            result+=i;
            sum+=result;
        }
        System.out.println(sum);
    }
}
