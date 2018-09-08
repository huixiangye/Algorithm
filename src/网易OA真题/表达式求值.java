package 网易OA真题;

import java.util.Scanner;

/**
 * Created by yehuixiang on 9/6/18.
 今天上课，老师教了小易怎么计算加法和乘法，乘法的优先级大于加法，但是如果一个运算加了括号，那么它的优先级是最高的。例如：
 1
 2
 3
 4
 1+2*3=7
 1*(2+3)=5
 1*2*3=6
 (1+2)*3=9
 现在小易希望你帮他计算给定3个数a，b，c，在它们中间添加"+"， "*"， "("， ")"符号，能够获得的最大值。

 输入描述:
 一行三个数a，b，c (1 <= a, b, c <= 10)


 输出描述:
 能够获得的最大值
 示例1
 输入
 1 2 3
 输出
 9
 */
public class 表达式求值 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();
        int c=s.nextInt();
        int max=Math.max(a+b+c,(a+b)*c);
        max=Math.max(max,a*(b+c));
        max=Math.max(max,a*b*c);
        System.out.println(max);

    }
}
