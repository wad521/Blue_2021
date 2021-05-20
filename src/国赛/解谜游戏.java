package 国赛;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 解谜游戏 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            String S3 = input.next();
            String S2 = input.next();
            String S1 = input.next();
            if (check(S1, S2, S3)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean check(String S1, String S2, String S3) {
        char[] s1 = S1.toCharArray();
        char[] s2 = S2.toCharArray();
        char[] s3 = S3.toCharArray();
        for (int i = 0; i < 4; i++) {
            Map<Character, Integer> map = new HashMap<>();
            map.put(s1[i], map.getOrDefault(s1[i], 0) + 1);
            map.put(s2[i], map.getOrDefault(s2[i], 0) + 1);
            map.put(s2[i + 4], map.getOrDefault(s2[i + 4], 0) + 1);
            map.put(s3[i], map.getOrDefault(s3[i], 0) + 1);
            map.put(s3[i + 4], map.getOrDefault(s3[i + 4], 0) + 1);
            map.put(s3[i + 8], map.getOrDefault(s3[i + 8], 0) + 1);
            if (map.get('Y') != 1 || map.get('R') != 2 || map.get('G') != 3) {
                return false;
            }
        }
        return true;
    }
}
