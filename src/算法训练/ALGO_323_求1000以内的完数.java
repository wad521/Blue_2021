package 算法训练;

public class ALGO_323_求1000以内的完数 {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++) {
            int sum = 0;
            for (int j = 1; j <= i / 2; j++) {
                //此处为整除，即余数为0
                if (i % j == 0) {
                    sum += j;
                }
            }
            if(sum==i){
                System.out.println(i);
            }
        }
    }
}
