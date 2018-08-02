package AmasonLeetcode.OA1debugging;

/**
 * Created by yehuixiang on 7/20/18.
 * sort array 选择排序,降序descending  > --> <
 */
public class sortArray1 {
    public static int[] sortArray(int arr[]){
        int i,max,location,j,temp,len = arr.length;
        for(i = 0; i<len; i++){
            max = arr[i];
            location = i;
            for(j = i; j<len;j++){
                if(max<arr[j]){
                    max = arr[j];
                    location = j;
                }
            }

            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }

        return arr;
    }

    public static void main(String[] args){
        int[] test = {20,2,3,5,9,6,16};
        sortArray1.sortArray(test);
        for(int i = 0; i<test.length;i++){
            System.out.print(test[i]+" ");
        }

    }
}
