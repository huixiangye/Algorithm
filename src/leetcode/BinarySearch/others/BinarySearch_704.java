package leetcode.BinarySearch.others;

/**
 * Created by yehuixiang on 9/2/18.
 * Given a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search target in nums. If target exists, then return its index,
 * otherwise return -1.


 Example 1:

 Input: nums = [-1,0,3,5,9,12], target = 9
 Output: 4
 Explanation: 9 exists in nums and its index is 4

 Example 2:

 Input: nums = [-1,0,3,5,9,12], target = 2
 Output: -1
 Explanation: 2 does not exist in nums so return -1

 */
public class BinarySearch_704 {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length-1;

        while(start + 1 < end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]<target){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(nums[start] == target){
            return start;
        }

        if(nums[end] == target){
            return end;
        }

        return -1;
    }

    public static void main(String[] args){
        int[] test = {-1,0,3,5,9,12};
        System.out.println(BinarySearch_704.search(test,9));
    }
}
