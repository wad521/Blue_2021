import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LanQiao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            int x = input.nextInt();
            if (x == -10000) {
                flag = false;
            }
            list.add(x);
        }
        System.out.println(list.size());
    }
}
