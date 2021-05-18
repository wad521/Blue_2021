package 算法提高;

import java.io.*;

/**
 * @author:yxl
 **/
public class 合唱队形 {
    //static int[] father;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while ((str = br.readLine()) != null) {
                int n = Integer.parseInt(str);
                String[] parts = br.readLine().split(" ");
                int[] nums = new int[n];
                int[] left = new int[n];//升序
                int[] right = new int[n];//降序
                for (int i = 0; i < n; i++) {
                    nums[i] = Integer.parseInt(parts[i]);
                }
                for (int i = 0; i < n; i++) {
                    left[i] = 1;
                    for (int j = i - 1; j >= 0; j--) {
                        if (nums[i] > nums[j])
                            left[i] = Math.max(left[i], left[j] + 1);
                    }
                }
                for(int s:left){
                    System.out.print(s+"   ");
                }
                System.out.println();
                for (int i = n - 1; i >= 0; i--) {
                    right[i] = 1;
                    for (int j = i + 1; j < n; j++) {
                        if (nums[i] > nums[j])
                            right[i] = Math.max(right[i], right[j] + 1);
                    }
                }
                for(int s:right){
                    System.out.print(s+"   ");
                }
                System.out.println();
                int max = 0;
                for (int i = 0; i < n; i++) {
                    max = Math.max(max, left[i] + right[i] - 1);
                }
                System.out.println(n - max);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
