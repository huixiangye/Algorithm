package leetcode.HashMap.不用HashMap用array代替的情况;

/**
 * Created by yehuixiang on 8/30/18.
 * Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram_242 {
    public static boolean isAnagram(String s, String t) {
        int[] map = new int[256];

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i<s.length(); i++){
            map[s.charAt(i)]++;
        }

        for(int i = 0; i<t.length(); i++){
            map[t.charAt(i)]--;
            if(map[t.charAt(i)]<0){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args){
       System.out.println(ValidAnagram_242.isAnagram("anagram","nagaram"));
    }
}
