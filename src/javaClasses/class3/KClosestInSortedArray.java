package javaClasses.class3;

import java.util.Arrays;

/**
 * Created by yehuixiang on 8/3/18.
 *
 * Given a target integer T, a non-negative integer K and
 * an integer array A sorted in ascending order,
 * find the k closest numbers to T in A.
 */
public class KClosestInSortedArray {
    public int[] kClosest(int[] array, int target, int k){
        if(array == null || array.length == 0){
            return array;
        }

        if(k == 0){
            return new int[0];
        }

        int left = largestSmallerEqual(array,target);
        int right = left + 1;
        int[] result = new int[k];

        for(int i = 0; i<k;i++){
            if(right >= array.length || left >= 0
                    && target-array[left] <= array[right] -target){
                result[i] = array[left--];
            }else{
                result[i] = array[right++];
            }
        }

        Arrays.sort(result);
        return result;
    }

    private int largestSmallerEqual(int[] array, int target) {
        int left = 0;
        int right = array.length -1;
        while(left<right-1){
            int mid = left + (right - left)/2;
            if(array[mid] <= target){
                left = mid;
            }else {
                right = mid;
            }
        }

        if(array[right] <= target){
            return right;
        }

        if(array[left] <= target){
            return left;
        }

        return -1;
    }

    public static void main(String[] args){
        int[] test = new int[]{1,2,3,4,5};
        KClosestInSortedArray sample = new KClosestInSortedArray();
        System.out.println(Arrays.toString(sample.kClosest(test,3,4)));
    }


}
