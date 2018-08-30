package leetcode.HashMap.不用HashMap用array代替的情况;

import java.util.Arrays;

/**
 * Created by yehuixiang on 8/30/18.
 *
 Given a string, find the first non-repeating character in it and return it's index.
 If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 */
public class FirstUniqueCharacter_in_a_String_387 {
    public static int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }

        int[] map = new int[256];
        Arrays.fill(map, 0);

        for(int i = 0; i < s.length();i++){
            map[s.charAt(i)]++;
        }

        for(int i = 0; i < s.length();i++){
            if(map[s.charAt(i)] == 1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println(FirstUniqueCharacter_in_a_String_387.firstUniqChar("leetcode"));
        System.out.println(FirstUniqueCharacter_in_a_String_387.firstUniqChar("loveleetcode"));
    }
}
