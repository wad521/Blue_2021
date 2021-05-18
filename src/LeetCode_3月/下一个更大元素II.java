package LeetCode_3月;

import java.util.*;

/**
 * @author:yxl
 **/
public class 下一个更大元素II {
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Stack<Integer> stack = new Stack<>();
        //每个元素都可能遍历到其后面n-1个元素，
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
}