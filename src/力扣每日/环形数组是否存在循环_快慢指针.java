package 力扣每日;

/**
 * @author:yxl
 **/
public class 环形数组是否存在循环_快慢指针 {
    public boolean circularArrayLoop(int[] nums) {
        //快慢指针
        int n = nums.length;
        for(int i =0;i<n;i++){
            //原地循环  || 已近遍历过但不符合条件
            if(nums[i]==0){
                break;
            }

            //快慢指针  让fast提前一步  可能更快的相遇 也可能更慢的相遇 让while条件容易写
            int slow = i , fast = next(nums,i);
            //判断方向情况
            while(nums[slow]*nums[fast]>0 && nums[i]*nums[next(nums,fast)]>0){
                if(slow==fast){
                    if(slow != next(nums,slow)){
                        return true;
                    }else{
                        break;
                    }
                }
                //进行快慢指针移动
                slow = next(nums,slow);
                fast = next(nums,next(nums,fast));
            }
            //跳出上一个while则证明存在不符合条件的下标，将其排除
            int add =i;
            while(nums[add]*nums[next(nums,add)]>0){
                int tmp = add;
                add = next(nums,add);
                nums[tmp] = 0;

            }
        }
        return false;
    }

    public int next(int[] nums, int i){
        int n = nums.length;
        return ((i+nums[i])%n + n)%n;
    }
}
