package leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yehuixiang on 8/3/18.
 * Given a sorted array, two integers k and x,
 * find the k closest elements to x in the array.
 * The result should also be sorted in ascending order.
 * If there is a tie, the smaller elements are always preferred.

 Example 1:
 Input: [1,2,3,4,5], k=4, x=3
 Output: [1,2,3,4]
 Example 2:
 Input: [1,2,3,4,5], k=4, x=-1
 Output: [1,2,3,4]


 思路分析: 数组是从小到大排好序的
         首先 x可能小于数组的第一个元素
             x可能大于数组的最后一个元素
             x是在这个数组范围内
         于是就分了三种情况。注意的点就是binary search是要返回的与x最相近的那个值可能是x本身
 如果找的到的话。
 */
public class FindKClosestElements_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        //the corner case
        if(arr == null || arr.length == 0 || k == 0){
            return res;
        }


        int start = 0;
        int end = arr.length-1;

        if(x >= arr[end]){// the target >= arr[arr.length -1]
            while(k > 0){
                res.add(arr[end--]);
                k--;
            }
        }else if(x <= arr[start]){//if target <= arr[0]
            while(k > 0){
                res.add(arr[start++]);
                k--;
            }
        }else{// arr[0]< target < arr[arr.length -1]
            int left = binarySearch(arr,x); // return the target is the closest element to the x
            int right = left+1;
            for(int i = 0; i < k; i++){
                if(right >= arr.length || left >= 0 && x - arr[left] <= arr[right] - x)
                    res.add(arr[left--]);
                else
                    res.add(arr[right++]);
            }

        }

        Collections.sort(res);
        return res;
    }


    // return the target is the closest element to the x
    public int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start + 1 < end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(arr[start] == target || target - arr[start] <= arr[end] - target)
            return start;

        if(arr[end] == target || target - arr[start] > arr[end] - target)
            return end;

        return -1;

    }

    public static void main(String[] args){
        FindKClosestElements_658 findKClosestElements658 = new FindKClosestElements_658();
        int[] case1 = new int[]{1,2,3,4,5};
        System.out.println(findKClosestElements658.findClosestElements(case1,4,3));

    }
}
