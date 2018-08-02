package AmasonLeetcode.OA2CODING;

/**
 * Created by yehuixiang on 7/27/18.
 * 二维数组里面找target题目
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 3
 Output: true
 */



public class searchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        //base case
        if(matrix == null || matrix.length == 0) return false;

        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m * n - 1;

        while(left<=right){
            int middle = left + (right - left) / 2;

            int i = middle / n;

            int j = middle % n;

            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j]>target){
                right = middle-1;
            }else{
                left = middle+1;
            }
        }


        return false;
    }

    public static void main(String[] args){
        int[][] test = new int[][]{{1,   3,  5,  7},
                                   {10, 11, 16, 20},
                                   {23, 30, 34, 50}
                                  };
        System.out.print(searchMatrix.searchMatrix(test,3));
        //true
    }
}
