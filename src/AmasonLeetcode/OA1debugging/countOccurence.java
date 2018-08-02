package AmasonLeetcode.OA1debugging;

/**
 * Created by yehuixiang on 7/25/18.
 */
public class countOccurence {
    public static int count(int[] arr, int value){
        int i = 0,count = 0, len = arr.length;
        while(i<len){
            if(arr[i] == value){
                count +=1;
            }

            i++;
        }

        return count;
    }

    public static void main(String[] args){
        int[] test = new int[]{20,2,3,5,9,6,16,2};
        System.out.print(countOccurence.count(test,2));
    }
}
