package AmasonLeetcode.OA2CODING;

/**
 * Created by yehuixiang on 7/27/18.
 * 我感觉题目是判断字符串s 是否向右 移动几位变成了 t
 */

public class RotateString {
    public static boolean isRotated(String s, String t) {
        if(s == null && t == null) return true;
        else if(s == null || t == null) return false;
        return (s.length() == t.length()) && ((s + s).indexOf(t) != -1);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "abcdef", t = "efabcd";
        System.out.println(isRotated(s, t));
    }

}
