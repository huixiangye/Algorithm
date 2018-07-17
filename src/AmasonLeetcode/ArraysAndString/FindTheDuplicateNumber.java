package AmasonLeetcode.ArraysAndString;

import java.util.Arrays;

/**
 * Created by yehuixiang on 7/14/18.
 */
public class FindTheDuplicateNumber {
    //I modify the array,because the binarySearch have to used in the sorted array.
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++){
            boolean res = binarySearch(nums,i+1,nums.length-1,nums[i]);
            if(res == true)
                return nums[i];
        }
        return -1;
    }

    public boolean binarySearch(int[] nums,int left,int right,int target){
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid]<target)
                left = mid;
            else
                right = mid;
        }

        if(nums[left] == target)
            return true;

        if(nums[right] == target)
            return true;

        return false;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,3,4,2,2};
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        System.out.print(findTheDuplicateNumber.findDuplicate(nums));
    }
}
