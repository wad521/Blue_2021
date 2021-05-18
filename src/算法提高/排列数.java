package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 排列数 {
    private static int[] arr = new int[10];
    private static boolean[] hasVisited = new boolean[10];
    private static int n;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs(0);

    }

    public static void dfs(int pos) {
        if (pos == 10) {
            count++;
            if (count == n) {
                for (int i:arr){
                    System.out.print(i);
                }
            }
        }
        else {
            for (int i = 0; i < 10; i++) {
                if (!hasVisited[i]) {
                    hasVisited[i] = true;
                    arr[pos] = i;
                    dfs(pos + 1);
                    hasVisited[i] = false;
                }
            }
        }
    }
}
