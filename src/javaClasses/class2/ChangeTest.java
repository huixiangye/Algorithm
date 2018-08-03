package javaClasses.class2;

/**
 * Created by yehuixiang on 8/3/18.
 */
class Simple{
    public int value;

    public Simple(int value){
        this.value = value;
    }
}
public class ChangeTest {
    public static void changeSampleValue1(Simple simple){
        Simple newSimple = new Simple(10);
        simple = newSimple;
    }

    private static void changeSampleValue2(Simple originalSimple) {
        originalSimple.value = 10;
    }


    private static Simple changeSampleValue3(Simple originalSimple) {
        Simple newSimple = new Simple(20);
        return newSimple;
    }

    private static void changeValue(int x) {
        x =10;
    }



    public static void main(String[] args){
        Simple originalSimple = new Simple(5);
        ChangeTest.changeSampleValue1(originalSimple);
        System.out.println(originalSimple.value);//打印出来仍然是5


        changeSampleValue2(originalSimple);
        System.out.println(originalSimple.value);//输出10;

        //here originalSimple is 10
        originalSimple = changeSampleValue3(originalSimple);
        System.out.println(originalSimple.value);//print should be 20

        int x = 5;
        changeValue(x);
        System.out.println(x);
    }




}
