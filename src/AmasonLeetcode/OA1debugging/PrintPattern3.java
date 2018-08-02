package AmasonLeetcode.OA1debugging;

/**
 * Created by yehuixiang on 7/20/18.
 */
public class PrintPattern3 {
    public static void print3(int num){
        int x = 1;
        for(int i = 1; i<=num;i++){
            for(int j = i; j>0;j--){
                System.out.print(x+""+x);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        print3(4);
    }
}
