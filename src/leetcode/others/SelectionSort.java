package leetcode.others;

/**
 * Created by yehuixiang on 6/28/18.
 */


class SelectionSort {

    public void selectionSort(int[] nums){
        int n = nums.length;
        int global,temp;

        for(int i = 0; i <n-1; i++){
            global = i; // define the global_min
            for(int j = i+1; j<n; j++ ){ // find the min in the array
                if(nums[j]<nums[global]){
                    global = j;
                }
            }

            temp = nums[i];
            nums[i] = nums[global];
            nums[global] = temp;
        }
    }

    public void iteration(int[] nums){
        for(int i = 0; i < nums.length; i++){
            System.out.print(" "+ nums[i]);
        }
    }


    public static void main(String[] args) {
        int[] test = new int[]{1,3,5,7,9,8,6,4,2,0};

        SelectionSort test1 = new SelectionSort();

        test1.selectionSort(test);
        test1.iteration(test);
    }

}