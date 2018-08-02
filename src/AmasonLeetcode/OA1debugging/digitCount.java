package AmasonLeetcode.OA1debugging;

/**
 * Created by yehuixiang on 7/20/18.
 */
public class digitCount {
    public static int count(int num){
        int count = 0;
        //这里要加个temp记录num值
        int temp = num;
        while(temp!=0){
            temp = temp/10;
            count++;
        }

        return (num%count);
    }

    public static void main(String[] args){
        System.out.print(digitCount.count(235));
    }

}
