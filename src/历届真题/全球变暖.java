package 历届真题;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 全球变暖 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = input.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
    }
}
