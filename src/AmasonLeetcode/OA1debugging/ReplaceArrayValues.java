package AmasonLeetcode.OA1debugging;

/**
 * Created by yehuixiang on 7/20/18.
 */
public class ReplaceArrayValues {
    public static int[] replaceArr(int[] arr){
        int i,j,len = arr.length;
        if(len % 2 ==0){
            for(i = 0; i<len;i++){
                //这里一定是小于len,若是小于等于len则会溢出
                arr[i] = 0;
            }
        }else{
            for(j = 0;j<len;j++){
                arr[j] = 1;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] test = new int[]{20,2,3,5,9,6,16};
        ReplaceArrayValues.replaceArr(test);
        for(int i = 0; i<test.length;i++){
            System.out.print(test[i]+" ");
        }
    }
}
