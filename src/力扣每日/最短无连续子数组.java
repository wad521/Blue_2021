package 力扣每日;

/**
 * @author:yxl
 **/
public class 最短无连续子数组 {
    static int MIN = -100005, MAX = 100005;

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
//        int n = nums.length;
//        int i = 0, j = n - 1;
//        while (i < j && nums[i] <= nums[i + 1]) i++;
//        while (i < j && nums[j] >= nums[j - 1]) j--;
//        int l = i, r = j;
//        int min = nums[i], max = nums[j];
//        for (int u = l; u <= r; u++) {
//            if (nums[u] < min) {
//                while (i >= 0 && nums[i] > nums[u]) i--;
//                min = i >= 0 ? nums[i] : MIN;
//            }
//            if (nums[u] > max) {
//                while (j < n && nums[j] < nums[u]) j++;
//                max = j < n ? nums[j] : MAX;
//            }
//        }


        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < j && nums[i + 1] >= nums[i]) {
            i++;
        }
        while (i < j && nums[j] >= nums[j - 1]) {
            j--;
        }
        int l = i, r = j;
        int min = nums[i], max = nums[j];

        //i和j会时刻变化 ，所以从l->r循环
        for (int x = l; x <= r; x++) {
            if (nums[x] < min) {
                while (i >= 0 && nums[x] < nums[i]) {
                    i--;
                }
                min = i >= 0 ? nums[i] : MIN;
            }

            if (nums[x] > max) {
                while (j < n && nums[x] > nums[j]) {
                    j++;
                }
                max = j < n ? nums[j] : MAX;
            }
        }

        if(i==j){
            return 0;
        }
        return (j - 1) - (i + 1) + 1;
    }
}


