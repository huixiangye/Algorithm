package others;

/**
 * Created by yehuixiang on 6/28/18.
 */

public class MergeSort {

    public void sort(int[] arr, int l,int r){
        if(l<r){
            int mid = l + (r - l)/2;

            sort(arr,l,mid);
            sort(arr,mid+1,r);

            merge(arr,l,mid,r);
        }
    }

    public void merge(int[] arr, int l,int m, int r){

        int n1 = m-l+1;
        int n2 = r-m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i<n1;i++){
            left[i] = arr[l+i];
        }
        for(int j = 0; j<n2;j++){
            right[j] = arr[m+j+1];
        }

        int i=0,j=0;
        int k = l;

        while(i<n1 && j<n2){
            if(left[i]<right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }

            k++;
        }

        while(i<n1){
            arr[k] = left[i];
            k++;
            i++;
        }

        while(j<n2){
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public void iteration(int[] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(" " + arr[i]);
        }
    }


    public static void main(String[] args) {
        int[] test = new int[]{1,3,5,7,9,8,6,4,2,0};

        MergeSort test1 = new MergeSort();

        test1.sort(test,0,9);
        test1.iteration(test);
    }
}
