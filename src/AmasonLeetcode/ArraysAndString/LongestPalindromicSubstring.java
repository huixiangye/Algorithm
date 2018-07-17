package AmasonLeetcode.ArraysAndString;

/**
 * Created by yehuixiang on 7/16/18.
 */
public class LongestPalindromicSubstring {
    static String res = "";
    public static String longestPalindrome(String s) {
//         if(s == null || s.length() == 0)
//             return null;
//         if(s.length() == 1)
//             return s;

//         boolean[][] dp = new boolean[s.length()][s.length()];
//         int maxStart = 0;
//         int maxEnd = 0;
//         for (int i = 0; i < s.length(); i++) {
//             for (int j = 0; j < s.length() - i; j++) {
//                 if (i == 0 || (s.charAt(j) == s.charAt(j + i) && (i == 1 || dp[j + 1][j + i - 1]))) {
//                     dp[j][j + i] = true;
//                     maxStart = j;
//                     maxEnd = j + i;
//                 }
//             }
//         }
//         return s.substring(maxStart, maxEnd + 1);

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
        String s = "babad";
        System.out.print(LongestPalindromicSubstring.longestPalindrome(s));

    }

}
