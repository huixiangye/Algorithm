package leetcode.HashMap.Word_Pattern问题;

import java.util.HashMap;

/**
 * Created by yehuixiang on 8/28/18.
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Example 1:

 Input: pattern = "abba", str = "dog cat cat dog"
 Output: true
 Example 2:

 Input:pattern = "abba", str = "dog cat cat fish"
 Output: false
 Example 3:

 Input: pattern = "aaaa", str = "dog cat cat dog"
 Output: false
 Example 4:

 Input: pattern = "abba", str = "dog dog dog dog"
 Output: false
 */
public class Word_Pattern_290 {
    public static boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        HashMap<Character,String > map = new HashMap<>();

        if(arr.length != pattern.length()){
            return false;
        }

        for(int i =0; i<arr.length;i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i])){
                    return false;
                }
            }else{
                if(map.containsValue(arr[i])){
                    return false;
                }

                map.put(c,arr[i]);
            }
        }

        return true;

    }

    public static void main(String[] args){
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(Word_Pattern_290.wordPattern(pattern,str));
    }
}
