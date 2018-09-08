package 网易OA真题;

import java.util.Scanner;

/**
 * Created by yehuixiang on 9/6/18.
 * 小易有一些立方体，每个立方体的边长为1，他用这些立方体搭了一些塔。
 现在小易定义：这些塔的不稳定值为它们之中最高的塔与最低的塔的高度差。
 小易想让这些塔尽量稳定，所以他进行了如下操作：每次从某座塔上取下一块立方体，并把它放到另一座塔上。
 注意，小易不会把立方体放到它原本的那座塔上，因为他认为这样毫无意义。
 现在小易想要知道，他进行了不超过k次操作之后，不稳定值最小是多少。

 输入描述:
 第一行两个数n,k (1 <= n <= 100, 0 <= k <= 1000)表示塔的数量以及最多操作的次数。
 第二行n个数，ai(1 <= ai <= 104)表示第i座塔的初始高度。


 输出描述:
 第一行两个数s, m，表示最小的不稳定值和操作次数(m <= k)
 接下来m行，每行两个数x,y表示从第x座塔上取下一块立方体放到第y座塔上。

 输入例子1:
 3 2
 5 8 5

 输出例子1:
 0 2
 2 1
 2 3
 */
public class 塔 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        while(s.hasNext()){
            n=s.nextInt();
            int k=s.nextInt();
            int[] nArrays = new int[n];
            for(int i=0;i<n;i++){
                nArrays[i]=s.nextInt();
            }
            int count=0;//记录操作次数
            int[] moves = new int[2*k];//用于记录操作路径
            while(count<k){
                int maxIndex = maxIndex(nArrays);
                int minIndex = minIndex(nArrays);
                if(nArrays[maxIndex]-nArrays[minIndex]>1){
                    nArrays[maxIndex]--;
                    nArrays[minIndex]++;
                    moves[2*count]=maxIndex+1;
                    moves[2*count+1]=minIndex+1;
                    count++;
                }else {
                    break;
                }
            }
            System.out.println(nArrays[maxIndex(nArrays)]-nArrays[minIndex(nArrays)]+" "+count);
            for(int i=0;i<count;i++){
                System.out.println(moves[2*i]+" "+moves[2*i+1]);
            }
        }
    }
    //找出最多立方体的塔的下标
    public static int maxIndex(int[] arrays){
        int max = arrays[0];
        int result = 0;
        for(int i=0;i<arrays.length;i++){
            if(arrays[i]>max){
                max=arrays[i];
                result=i;
            }
        }
        return result;
    }
    //找出最少立方体的塔的下标
    public static int minIndex(int[] arrays){
        int min = arrays[0];
        int result = 0;
        for(int i=0;i<arrays.length;i++){
            if(arrays[i]<min){
                min=arrays[i];
                result=i;
            }
        }
        return result;
    }

}
