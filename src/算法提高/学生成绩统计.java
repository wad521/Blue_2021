package 算法提高;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 学生成绩统计 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String max_s = "", min_s = "";
        double max_avg = Integer.MIN_VALUE, min_avg = Integer.MAX_VALUE;
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            String s = input.next();
            int id = input.nextInt();
            int maths = input.nextInt();
            int english = input.nextInt();
            int cpp = input.nextInt();
            double avg = (maths + english + cpp) / 3;
            if (avg > max_avg) {
                max_avg = avg;
                max_s = s;
            }
            if (avg < min_avg) {
                min_avg = avg;
                min_s = s;
            }
        }
        System.out.println(max_s);
        System.out.println(min_s);
    }
}
