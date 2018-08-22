package leetcode.HashMap.HashSet;

import java.util.HashSet;

/**
 * Created by yehuixiang on 8/21/18.
 * Given an array of integers, find if the array contains any duplicates.

 Your function should return true if any value appears at least twice in the array,
 and it should return false if every element is distinct.

 Example 1:

 Input: [1,2,3,1]
 Output: true
 Example 2:

 Input: [1,2,3,4]
 Output: false
 Example 3:

 Input: [1,1,1,3,3,4,3,2,4,2]
 Output: true
 */
public class ContainsDuplicate_217 {
    public static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i <nums.length; i++){
            if(!set.add(nums[i])){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[] test = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(ContainsDuplicate_217.containsDuplicate(test));
    }
}
