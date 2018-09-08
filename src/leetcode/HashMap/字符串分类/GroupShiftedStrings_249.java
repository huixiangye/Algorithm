package leetcode.HashMap.字符串分类;

import java.util.*;

/**
 * Created by yehuixiang on 9/2/18.
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of strings which contains only lowercase alphabets,
 group all strings that belong to the same shifting sequence.

 Example:

 Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 Output:
 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]
 */
public class GroupShiftedStrings_249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strings) {
            // 我们可以用最开始的string来找到一个offset，相对于以a开头的那个标准值
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                // 让整个array循环起来
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }

            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }

            map.get(key).add(str);
        }

        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }

        return result;
    }
}
