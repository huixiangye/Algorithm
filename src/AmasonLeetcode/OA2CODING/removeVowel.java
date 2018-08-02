package AmasonLeetcode.OA2CODING;

/**
 * Created by yehuixiang on 7/27/18.
 * 去掉元音字母 a e i o u A E I O U
 */
public class removeVowel {
    public static String removeVowel(String s){
        String t = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            if(t.indexOf(c)>=0) continue;
            sb.append(c);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(removeVowel("abcdefghijk"));
    }


}
