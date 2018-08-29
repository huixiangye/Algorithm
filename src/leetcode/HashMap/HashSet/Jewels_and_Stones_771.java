package leetcode.HashMap.HashSet;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yehuixiang on 8/28/18.
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

 The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

 Example 1:

 Input: J = "aA", S = "aAAbbbb"
 Output: 3
 Example 2:

 Input: J = "z", S = "ZZ"
 Output: 0
 */
public class Jewels_and_Stones_771 {
    public static int numJewelsInStones(String J, String S) {
        int res = 0;
        if(J == null || J.length() == 0 || S == null || S.length() == 0)
            return res;

        HashSet<Character> set = new HashSet<>();

        for(char j : J.toCharArray()){
            set.add(j);
        }

        for(char s: S.toCharArray()){
            if(set.contains(s)){
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args){
        String J = "Aa";
        String S = "Aaabbbbbb";
        System.out.println(Jewels_and_Stones_771.numJewelsInStones(J,S));
    }
}
