package leetcode.HashMap.不用HashMap用array代替的情况;

/**
 * Created by yehuixiang on 8/30/18.
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom note
 * can be constructed from the magazines ; otherwise, it will return false.

 Each letter in the magazine string can only be used once in your ransom note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 */
public class RansomNote_383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[256];

        for(int i = 0; i<magazine.length();i++){
            arr[magazine.charAt(i)]++;
        }

        for(int i = 0 ; i<ransomNote.length(); i++){
            if(--arr[ransomNote.charAt(i)] <0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(RansomNote_383.canConstruct("a","b"));
        System.out.println(RansomNote_383.canConstruct("aa", "ab"));
        System.out.println(RansomNote_383.canConstruct("aa", "aab"));
    }
}
