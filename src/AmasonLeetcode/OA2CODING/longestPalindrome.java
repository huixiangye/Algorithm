package AmasonLeetcode.OA2CODING;

/**
 * Created by yehuixiang on 7/27/18.
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */
//中心开花的做法


public class longestPalindrome {
    static String res = "";

    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        for(int i = 0; i<s.length();i++){
            helper(s,i,i);
            helper(s,i,i+1);

        }

        return res;
    }

    public static void helper(String s, int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        String cur = s.substring(left+1,right);
        if(cur.length()>res.length()){
            res = cur;
        }
    }

    public static void main(String[] args){
        //String s1 = "babad";
        //System.out.print(longestPalindrome.longestPalindrome(s1));
        System.out.println();
        System.out.print(longestPalindrome.longestPalindrome("cbbd"));
    }
}
