package 算法提高;

import java.util.Arrays;

/**
 * @author:yxl
 **/
public class 找出出卖耶稣的人 {
    public static void main(String[] args) {
        int[] people = new int[13];
        Arrays.fill(people, 1);
        //出局的人数。
        int shot = 0;
        int idx = 0, count = 1;
        while (shot != 13) {
            if (people[idx] == 1) {
                if (count == 3) {
                    shot++;
                    people[idx] = 0;
                    count = 1;
                    System.out.println(idx + 1);
                } else {
                    count++;
                }
                idx = (idx + 1) % 13;
            }else{
                idx = (idx + 1) % 13;
            }
        }
    }
}
