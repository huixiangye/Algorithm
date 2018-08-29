package leetcode.HashMap.HashMap的配对问题;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yehuixiang on 8/23/18.
 * Given a string, determine if a permutation of the string could form a palindrome.

 Example 1:

 Input: "code"
 Output: false
 Example 2:

 Input: "aab"
 Output: true
 Example 3:

 Input: "carerac"
 Output: true
 */
public class PalindromePermutation_266 {

    public static boolean canPermutePalindrome(String s) {
        Set<Character> set=new HashSet<Character>();
        for(int i=0; i<s.length(); ++i){
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else
                set.remove(s.charAt(i));
        }
        return set.size()==0 || set.size()==1;
    }

    public static void main(String[] args){
        String test = "code";
        System.out.println(PalindromePermutation_266.canPermutePalindrome(test));
    }

}
