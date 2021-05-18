package 滑动窗口;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author:yxl
 **/
public class 绝对差不超过限制的最长连续子数组 {
    public static void main(String[] args) {
        int[] nums = {8,2,3,2,4,5,7};
        System.out.println(longestSubarray1(nums,4));
    }

    public  static int longestSubarray(int[] nums, int limit) {
        //窗口内的最小数->最大数排序。
        //<窗口内的数，该数的个数>
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            for (Map.Entry<Integer, Integer> ss : map.entrySet()){
                System.out.print(ss.toString()+"   ");
            }
            System.out.println();
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }


    public static int longestSubarray1(int[] nums, int limit) {
        //统计当前窗口内的最大值与最小值
        Deque<Integer> queMax = new LinkedList<Integer>();
        Deque<Integer> queMin = new LinkedList<Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                queMax.pollLast();
            }
            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                queMin.pollLast();
            }
            queMax.offerLast(nums[right]);
            queMin.offerLast(nums[right]);
            while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                if (nums[left] == queMin.peekFirst()) {
                    queMin.pollFirst();
                }
                if (nums[left] == queMax.peekFirst()) {
                    queMax.pollFirst();
                }
                left++;
            }
            System.out.print("Max:");
            for (Integer i : queMax){
                System.out.print(i+" ");
            }
            System.out.println();
            System.out.print("Min:");
            for (Integer i : queMin){
                System.out.print(i+" ");
            }
            System.out.println();
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}
