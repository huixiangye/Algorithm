package leetcode.BinarySearch.二分法资料;

/**
 * Created by yehuixiang on 9/2/18.
 */
public class 二分查找模板 {
    public int findPosition1(int[] nums, int target){
        if(nums == null || nums.length ==0){
            return -1;
        }

        int start = 0, end = nums.length -1;
        //这里 start = 1， end = 2就退出
        while(start + 1 < end){
            //start and end ~ 2^31
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                start = mid;
            } else {
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


    //First Position of Target

    //给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1。
    //样例
    //在数组 [1, 2, 3, 3, 4, 5, 10] 中二分查找3，返回2。

    //这里与Leetcode的search insert position不同的是，这里如果没有找到一样的，我们需要返回 -1；

    public int findPosition2(int[] nums, int target){
        if(nums == null || nums.length ==0){
            return -1;
        }

        int start = 0, end = nums.length -1;
        //这里 start = 1， end = 2就退出
        while(start + 1 < end){
            //start and end ~ 2^31
            int mid = start + (end - start)/2;
            //not find any position, find the first position
            if(nums[mid] == target){
                end = mid;
            } else if (nums[mid] < target){
                // start = mid + 1; 也可以只是需要一些记忆
                start = mid;
            } else {
                // end = mid -1;也可以只是需要一些记忆
                end = mid;
            }
        }

        // double check,因为大部分出来的情况都是相邻关系， 在while循环里面不return，我们只是把范围缩小到可以人工检查的时候，手动的检查
        if(nums[start] == target){
            return start;
        }

        if(nums[end] == target){
            return end;
        }

        return -1;

    }



   // Last position of target

    public int lastPosition3(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }

        int start = 0, end = nums.length -1;
        //这里 start = 1， end = 2就退出
        while(start + 1 < end){
            //start and end ~ 2^31
            int mid = start + (end - start)/2;
            //not find any position, find the first position
            if(nums[mid] == target){
                start = mid;
            } else if (nums[mid] < target){
                // start = mid + 1; 也可以只是需要一些记忆
                start = mid;
            } else {
                // end = mid -1;也可以只是需要一些记忆
                end = mid;
            }
        }

        // double check,因为大部分出来的情况都是相邻关系， 在while循环里面不return，我们只是把范围缩小到可以人工检查的时候，手动的检查
        if(nums[end] == target){
            return end;
        }

        //和上面不一样的是先检查最后一个，因为是last position of target
        if(nums[start] == target){
            return start;
        }

        return -1;

    }
}
