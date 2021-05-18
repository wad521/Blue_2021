package 算法训练;

import java.util.*;

public class _负2进制 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    sc.close();

    int[] nums = binary(num);

    for(int i = nums.length - 1 ; i >= 0 ; i--){
        System.out.print(nums[i]);
    }
}

    public static int[] binary(int num){
        int i = 0;

        int[] nums = new int[100];

        if(num == 0){
            nums[0] = 0;
            nums = Arrays.copyOfRange(nums, 0, 1);
            return nums;
        }

        while(num != 0){
            nums[i] = Math.abs(num % -2);
            num = (num - nums[i++]) / -2;
        }

        nums = Arrays.copyOfRange(nums, 0, i);
        return nums;
    }
}
