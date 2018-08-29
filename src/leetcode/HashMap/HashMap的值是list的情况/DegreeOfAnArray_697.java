package leetcode.HashMap.HashMap的值是list的情况;

import java.util.HashMap;

/**
 * Created by yehuixiang on 8/23/18.
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.
 Example 2:
 Input: [1,2,2,3,1,4,2]
 Output: 6
 */
public class DegreeOfAnArray_697 {

    public static int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        HashMap<Integer,int[]> map = new HashMap<>();

        for(int i = 0; i < nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new int[]{1,i,i});
            }else{
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }

        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;

        for(int[] value: map.values()){
            if(value[0]>degree){
                degree = value[0];
                res = value[2]-value[1]+1;
            }else if(value[0] == degree){
                res = Math.min(value[2]-value[1]+1,res);
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] test = {1,2,2,3,1,4,2};
        System.out.println(DegreeOfAnArray_697.findShortestSubArray(test));
    }
}
