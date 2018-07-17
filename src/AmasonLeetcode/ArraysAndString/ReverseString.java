package AmasonLeetcode.ArraysAndString;

/**
 * Created by yehuixiang on 7/13/18.
 */
public class ReverseString {
    public String reverseString(String s) {
        if(s == null || s.length() == 0)
            return "";

        char[] tempArray = s.toCharArray();
        int l = 0;
        int r = tempArray.length-1;

        while(l<=r){
            char temp = tempArray[l];
            tempArray[l] = tempArray[r];
            tempArray[r] = temp;
            l++;
            r--;
        }

        return new String(tempArray);
    }

    public static void main(String[] args){
        String test = "hello";
        ReverseString reverseString = new ReverseString();
        System.out.print(reverseString.reverseString(test));
    }
}
