package AmasonLeetcode.ArraysAndString;

/**
 * Created by yehuixiang on 7/14/18.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0)
            return -1;

        char[] temp = s.toCharArray();
        int[] num = new int[256];

        for(int i = 0; i<s.length();i++){
            num[temp[i]-'a']++;
        }

        for(int i = 0; i<s.length();i++){
            if(num[temp[i]-'a'] == 1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        String test1 = "leetcode";
        String test2 = "loveleetcode";

        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();
        System.out.println(firstUniqueCharacterInAString.firstUniqChar(test1));
        System.out.println(firstUniqueCharacterInAString.firstUniqChar(test2));
    }
}
