package AmasonLeetcode.OA1debugging;

/**
 * Created by yehuixiang on 7/20/18.
 */
public class ReverseArray {
    public static int[] reverse(int[] arr){
        int i,temp,originallen = arr.length;
        int len = originallen;

        for(i = 0; i<originallen/2;i++){
            temp = arr[len-1];
            arr[len-1] = arr[i];
            arr[i] = temp;
            len = len -1;
        }
        return arr;
    }

    //改正方法2：reverse array: arr[len - 1]改成arr[len-i-1], 并且去掉len+=1.

    public static void main(String[] args){
        int[] test = {20,2,3,5,9,6,16};
        ReverseArray.reverse(test);
        for(int i = 0; i<test.length;i++){
            System.out.print(test[i]+" ");
        }
    }
}
