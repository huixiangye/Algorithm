package leetcode.BinarySearch.按照位置来二分;

/**
 * Created by yehuixiang on 9/4/18.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 The array may contain duplicates.

 Example 1:

 Input: [1,3,5]
 Output: 1
 Example 2:

 Input: [2,2,2,0,1]
 Output: 0
 */
public class FindMinimum_in_RotatedSortedArrayII_154 {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0 ){
            return -1;
        }

        int start = 0, end = nums.length -1;

        if(nums[start]<nums[end]){
            return nums[start];
        }

        while(start+1<end){
            int mid = start + (end-start)/2;

            if(nums[mid] == nums[start]){
                start++;
            }else if(nums[mid] == nums[end]){
                end--;
            }else if(nums[mid]>nums[start]){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(nums[start] < nums[end]){
            return nums[start];
        }

        return nums[end];
    }
}
