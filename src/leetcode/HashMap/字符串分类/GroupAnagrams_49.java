package leetcode.HashMap.字符串分类;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yehuixiang on 8/30/18.
 * Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:

 All inputs will be in lowercase.
 The order of your output does not matter
 */
public class GroupAnagrams_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();

        HashMap<String, List> ans = new HashMap<>();
        for(String s: strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList());
            }

            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }

    public static void main(String[] args){
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(GroupAnagrams_49.groupAnagrams(test));
    }
}
