package 算法提高;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:yxl
 **/
public class 明明的随机数 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] student = new int[N];
        //Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            student[i] = input.nextInt();
        }
        Arrays.sort(student);
        int count = 0;
        for (int i = 1; i < N; i++) {
            if (student[i] == student[i - 1]) {
                student[i - 1] = 1001;
                count++;
            }
        }
        Arrays.sort(student);
        System.out.println(N - count);
        for (int i = 0; i < N - count; i++) {
            System.out.print(student[i] + " ");
        }
    }
}
