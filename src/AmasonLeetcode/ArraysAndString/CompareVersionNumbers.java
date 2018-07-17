package AmasonLeetcode.ArraysAndString;

/**
 * Created by yehuixiang on 7/16/18.
 */
public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null)
            return 0;

        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i = 0;

        while(i< arr1.length || i < arr2.length){
            if(i<arr1.length && i<arr2.length){
                if(Integer.parseInt(arr1[i])<Integer.parseInt(arr2[i])){
                    return -1;
                }else if(Integer.parseInt(arr1[i])>Integer.parseInt(arr2[i])){
                    return 1;
                }
            }else if(i<arr1.length){
                if(Integer.parseInt(arr1[i]) != 0)
                    return 1;
            }else if(i<arr2.length){
                if(Integer.parseInt(arr2[i]) != 0)
                    return -1;
            }

            i++;
        }

        return 0;
    }

    public static void main(String[] args){
        String version1 = "1.0.1.0";
        String version2 = "1.0.1";

        System.out.print(CompareVersionNumbers.compareVersion(version1,version2));
    }
}
