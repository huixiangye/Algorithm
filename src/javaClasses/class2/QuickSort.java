package javaClasses.class2;

import java.util.Arrays;

/**
 * Created by yehuixiang on 8/3/18.
 */
public class QuickSort {
    public void quickSort(int[] array){
        if(array == null){
            return;
        }

        quickSort(array,0,array.length-1);
    }

    public void quickSort(int[] array,int left,int right){
        if(left > right){
            return;
        }

        //define a pivot and use the pivot to partition array
        //recursion 思想
        int pivotPos = partition(array,left,right);
        quickSort(array,left,pivotPos-1);
        quickSort(array,pivotPos+1,right);

    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = pivotIndex(left,right);
        int pivot = array[pivotIndex];
        //swap
        swap(array,pivotIndex,right);

        int leftBound = left;
        int rightBound = right-1;
        while(leftBound <= rightBound){
            if(array[leftBound]<pivot){
                leftBound++;
            }else if(array[rightBound]>=pivot){
                rightBound--;
            }else{
                swap(array,leftBound++,rightBound++);
            }
        }

        //swap back the pivot element
        swap(array,leftBound,right);
        return leftBound;
    }

    private int pivotIndex(int left, int right) {
        //sample implementation, pick random element as pivot each time;
        return left+(int)(Math.random()*(right-left+1));
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args){
        QuickSort test = new QuickSort();

        int[] array = {2,5,3,1,4};
        test.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
