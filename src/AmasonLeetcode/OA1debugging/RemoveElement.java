package AmasonLeetcode.OA1debugging;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by yehuixiang on 7/20/18.
 */
public class RemoveElement {
    public static int[] removeElement(int[] arr,int index){
        int i ,j,len =arr.length;
        if(index<len){
            for(i = index;i<len-1;i++){
                arr[i] = arr[i+1];
            }

            int[] res = new int[len-1];
            for(j = 0;j<len-1;j++){
                res[j] = arr[j];
            }

            return res;
        }else{
            return arr;
        }
    }

    public static void main(String[] args){
        int[] test = {20,2,3,5,9,6,16};

        System.out.print(Arrays.toString(RemoveElement.removeElement(test,3)));

    }
}
