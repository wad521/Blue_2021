package 基础练习;

import java.util.Scanner;

public class Basic_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble(), y1 = input.nextDouble(), x2 = input.nextDouble(), y2 = input.nextDouble();
        double x3 = input.nextDouble(), y3 = input.nextDouble(), x4 = input.nextDouble(), y4 = input.nextDouble();

        double max_quire1_x = Math.max(x1, x2);
        double min_quire1_x = Math.min(x1, x2);
        double max_quire1_y = Math.max(y1, y2);
        double min_quire1_y = Math.min(y1, y2);
        double max_quire2_x = Math.max(x3, x4);
        double min_quire2_x = Math.min(x3, x4);
        double max_quire2_y = Math.max(y3, y4);
        double min_quire2_y = Math.min(y3, y4);

        if (min_quire2_x >= max_quire1_x || min_quire1_x >= max_quire2_x
                || min_quire1_y >= max_quire2_y || min_quire2_y >= max_quire1_y) {
            System.out.println("0.00");
        } else {
            double l = Math.abs(Math.max(min_quire1_x, min_quire2_x) - Math.min(max_quire1_x, max_quire2_x));
            double h = Math.abs(Math.max(min_quire1_y, min_quire2_y) - Math.min(max_quire1_y, max_quire2_y));
            System.out.printf("%.2f", l * h);
        }
    }
}
