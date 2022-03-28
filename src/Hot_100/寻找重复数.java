package Hot_100;

/**
 * @author:yxl
 **/
public class 寻找重复数 {
    //快慢指针
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        //找相遇点
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //0不会被其他index指向，必定在环外
        int pre1 = 0;
        int pre2 = slow;
        //开始移动
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
