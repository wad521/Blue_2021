package 力扣每日;

/**
 * @author:yxl
 **/
public class 二分查找 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l =0,r=n-1;
        while(l<=r){
            int mid =(l+r)>>1;
            if(nums[mid]>target){
                r = mid-1 ;
            }else if(nums[mid]<target){
                l = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
