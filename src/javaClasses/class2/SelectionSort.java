package javaClasses.class2;

import java.util.Arrays;

/**
 * Created by yehuixiang on 8/3/18.
 */
public class SelectionSort {
    public static int[] selection(int[] nums){
        if(nums == null || nums.length <=1){
            return nums;
        }
        int i,j,min,index;
        for(i = 0; i<nums.length;i++){
            index = i;
            min = nums[i];
            for(j = i;j<nums.length;j++){
                if(min>nums[j]){
                    min = nums[j];
                    index = j;
                }

            }
            System.out.println("this loop the min value is: "+ min);

            //swap;
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }

        return nums;
    }

    public static void main(String[] args){
        int[] test = new int[]{2,3,20,5,7,2,5,1,11,1};
        System.out.println(Arrays.toString(SelectionSort.selection(test)));

    }
}
