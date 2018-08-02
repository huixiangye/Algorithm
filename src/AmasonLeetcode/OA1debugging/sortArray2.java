package AmasonLeetcode.OA1debugging;

/**
 * Created by yehuixiang on 7/20/18.
 * descending order
 */
public class sortArray2 {
    public static int[] sortArrayDes(int[] arr){
        int len = arr.length;
        int small,pos,i,j,temp;
        for(i = 0; i<len;i++){
            temp = 0;
            for(j = i; j<len;j++){
                if(arr[i]<arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;

    }


    public static void main(String[] args){
        int[] test = {20,2,3,5,9,6,16};
        sortArray2.sortArrayDes(test);
        for(int i = 0; i<test.length;i++){
            System.out.print(test[i]+" ");
        }

    }
}
