package leetcode.BinarySearch.按照位置来二分;

/**
 * Created by yehuixiang on 9/4/18.
 */
public class FindMinimum_in_RotatedSortedArray_153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        // 这是非rotate的情况，我们可以单独考虑，123
        if(nums[start] < nums[end]){
            return nums[start];
        }

        while(start + 1 < end){
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[start]){
                start = mid;
            }else{
                end = mid;
            }
        }

        // 跳出来的情况就是我们只有两个数的情况
        if(nums[start] < nums[end]){
            return nums[start];
        }

        return nums[end];
    }
}
