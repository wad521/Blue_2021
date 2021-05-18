package 算法训练;
//未成功
import java.util.Scanner;

public class ALGO_286 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        if(n==1){
            System.out.println(0);
        }else{
            System.out.println(permutation(n,k)*combination(n,k));
        }
    }

    private static int combination(int n, int k) {
        int a = 1, b = 1;
        for(int i = 1; i <= k; i++) {
            a *= (n - i + 1);
            b *= i;
        }
        return a / b;
    }

    private static int permutation(int n, int k) {
        int ans = 1;
        for(int i = 1; i <= k; i++) {
            ans *= (n - i + 1);
        }
        return ans;
    }
}
