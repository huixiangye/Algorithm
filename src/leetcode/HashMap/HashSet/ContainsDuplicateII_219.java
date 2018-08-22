package leetcode.HashMap.HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yehuixiang on 8/22/18.
 *
 * Given an array of integers and an integer k,
 find out whether there are two distinct indices i and j in the array
 such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

 Example 1:

 Input: nums = [1,2,3,1], k = 3
 Output: true
 Example 2:

 Input: nums = [1,0,1,1], k = 1
 Output: true
 Example 3:

 Input: nums = [1,2,3,1,2,3], k = 2
 Output: false
 */
public class ContainsDuplicateII_219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] test = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(ContainsDuplicateII_219.containsNearbyDuplicate(test,2));
    }
}

