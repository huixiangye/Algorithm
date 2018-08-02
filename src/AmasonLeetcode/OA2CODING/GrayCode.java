package AmasonLeetcode.OA2CODING;

/**
 * Created by yehuixiang on 7/27/18.
 */
public class GrayCode {
    public static boolean isConsecutive(byte a, byte b) {
        byte c = (byte)(a ^ b);
        int count = 0;
        while(c != 0) {
            c &= (c - 1);
            count++;
        }
        return count == 1;
    }

}
