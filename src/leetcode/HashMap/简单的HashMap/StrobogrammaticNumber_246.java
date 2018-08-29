package leetcode.HashMap.简单的HashMap;

import java.util.HashMap;

/**
 * Created by yehuixiang on 8/22/18.
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 Example 1:

 Input:  "69"
 Output: true
 Example 2:

 Input:  "88"
 Output: true
 Example 3:

 Input:  "962"
 Output: false
 */
public class StrobogrammaticNumber_246 {
    public static boolean isStrobogrammatic(String num) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('6','9');
        map.put('9','6');
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');

        int l = 0,r = num.length()-1;

        while(l<=r){
            if(!map.containsKey(num.charAt(l)))
                return false;
            if(map.get(num.charAt(l)) != num.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args){
        String test = "6699";
        System.out.println(StrobogrammaticNumber_246.isStrobogrammatic(test));
    }
}
