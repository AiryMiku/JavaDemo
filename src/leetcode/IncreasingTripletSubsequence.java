package leetcode;

/**
 * Created by Airy on 2018/7/15
 */

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {

    }

    /**
     * 维护一个pre < mid 的关系，当遇到比mid大的数字就代表有长度为3的递增子序列
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int pre = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i] <= pre){
                pre=nums[i];
            }else if(nums[i] <= mid){
                mid=nums[i];
            }else{
                return true;
            }
        }
        return false;
    }

}
