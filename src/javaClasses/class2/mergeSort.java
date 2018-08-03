package javaClasses.class2;

import java.util.ArrayList;

/**
 * Created by yehuixiang on 8/3/18.
 */
public class mergeSort {
    public ArrayList<Integer> mergeSort(ArrayList<Integer> array){
        if(array == null){
            return array;
        }

        return mergeSort(array,0,array.size()-1);
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> array, int left, int right){
        ArrayList<Integer> result = new ArrayList<>();
        if(left>right){
            return result;
        }

        if(left == right){
            result.add(array.get(left));
            return result;
        }

        int mid = left + (right -left)/2;
        ArrayList<Integer> reLeft = mergeSort(array,left,mid);
        ArrayList<Integer> reRight = mergeSort(array,mid+1,right);
        merge(reLeft,reRight,result);
        return result;
    }

    private void merge(ArrayList<Integer> left, ArrayList<Integer> right,ArrayList<Integer> result) {
        int l = 0;
        int r = 0;
        while(l < left.size() && r < right.size()){
            if(left.get(l)<=right.get(r)){
                result.add(left.get(l++));
            }else{
                result.add(right.get(r++));
            }
        }

        while(l<left.size()){
            result.add(left.get(l++));
        }

        while(r<right.size()){
            result.add(right.get(r++));
        }
    }

    public static void main(String[] args){
        mergeSort test = new mergeSort();
        ArrayList<Integer> array = new ArrayList<>();
        array.add(2);
        array.add(5);
        array.add(3);
        array.add(1);
        array.add(4);
        System.out.println(test.mergeSort(array));
    }
}
