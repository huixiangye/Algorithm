package leetcode.HashMap.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yehuixiang on 8/28/18.
 * Given two arrays, write a function to compute their intersection.

 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]
 Note:

 Each element in the result must be unique.
 The result can be in any order.



 */
public class IntersectionofTwoArrays_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int num1: nums1){
            set.add(num1);
        }

        List<Integer> res = new ArrayList<>();
        for(int num2: nums2){
            if(set.contains(num2)){
                res.add(num2);
                set.remove(num2);
            }
        }

        int[] result = new int[res.size()];
        int i = 0;
        for(int num: res){
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args){
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(Arrays.toString(IntersectionofTwoArrays_349.intersection(num1,num2)));
    }
}
