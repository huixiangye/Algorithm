package leetcode.HashMap.Word_Pattern问题;

import java.util.HashMap;

/**
 * Created by yehuixiang on 8/30/18.
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with
 another character while preserving the order of characters.
 No two characters may map to the same character but a character may map to itself.

 Example 1:

 Input: s = "egg", t = "add"
 Output: true
 Example 2:

 Input: s = "foo", t = "bar"
 Output: false
 Example 3:

 Input: s = "paper", t = "title"
 Output: true
 */
public class IsomorphicStrings_205 {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        if(ss.length != tt.length){
            return false;
        }

        for(int i = 0; i<ss.length;i++){
            if(map.containsKey(ss[i])){
                if(!map.get(ss[i]).equals(tt[i])){
                    return false;
                }
            }else{
                if(map.containsValue(tt[i])){
                    return false;
                }
                map.put(ss[i],tt[i]);
            }
        }

        return true;

    }

    public static void main(String[] args){
        String s = "aa";
        String t = "ab";
        System.out.println(IsomorphicStrings_205.isIsomorphic(s,t));
    }
}
