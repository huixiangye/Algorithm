package AmasonLeetcode.ArraysAndString;

/**
 * Created by yehuixiang on 7/14/18.
 */
public class ReverseWordsinaStringII {
    public void reverseWords(char[] str) {
        if(str == null || str.length == 0)
            return;

        int left = 0;
        int right = str.length-1;
        int temp = 0;

        //i love yahoo
        reverse(str,left,right);

        for(int i = 0;i<str.length;i++){
            if(str[i] == ' '){
                reverse(str,temp,i-1);
                temp = i+1;
            }

            if(i+1 == str.length){
                reverse(str,temp,i);
            }
        }

    }

    public void reverse(char[] str, int left,int right){
        while(left<=right){
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        char[] str = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        ReverseWordsinaStringII reverseWordsinaStringII = new ReverseWordsinaStringII();
        reverseWordsinaStringII.reverseWords(str);
        System.out.print(str);
    }
}
