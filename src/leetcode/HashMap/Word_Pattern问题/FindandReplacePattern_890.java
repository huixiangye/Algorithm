package leetcode.HashMap.Word_Pattern问题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yehuixiang on 8/30/18.
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.

 A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

 (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

 Return a list of the words in words that match the given pattern.

 You may return the answer in any order.



 Example 1:

 Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 Output: ["mee","aqq"]
 Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 since a and b map to the same letter.
 */
public class FindandReplacePattern_890 {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        if(words == null || words.length == 0){
            return res;
        }

        for(String word:words){
            if(isPattern(word,pattern)){
                res.add(word);
            }
        }

        return res;
    }

    public static boolean isPattern(String word,String pattern){
        HashMap<Character,Character> map = new HashMap<>();

        for(int i = 0; i<word.length(); i++){
            if(map.containsKey(word.charAt(i))){
                if(!map.get(word.charAt(i)).equals(pattern.charAt(i))){
                    return false;
                }
            }else{
                if(map.containsValue(pattern.charAt(i))){
                    return false;
                }

                map.put(word.charAt(i),pattern.charAt(i));
            }
        }

        return true;
    }

    public static void main(String[] args){
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";

        System.out.println(FindandReplacePattern_890.findAndReplacePattern(words,pattern));
    }
}
