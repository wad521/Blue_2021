package 杨辉三角;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] num = new int[n+1];
        num[0] = 1;
        int first, second;
        for (int i = 0; i < n; i++) {
            first = num[0];
            second = num[1];
            for (int j = 1; j <= i; j++) {
                num[j] = first + second;
                first =second;
                second = num[j+1];
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(num[j] + " ");
            }
            System.out.println();
        }
    }
}