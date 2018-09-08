package leetcode.BinarySearch.二维二分法;

/**
 * Created by yehuixiang on 9/2/18.
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 Example 1:

 Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 3
 Output: true
 Example 2:

 Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 13
 Output: false
 */
public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows*cols -1;

        while(low+1<high){
            int mid =  low + (high - low)/2;
            int midValue = matrix[mid / cols][mid % cols];
            if (midValue == target)
                return true;
            else if (midValue < target)
                low = mid;
            else
                high = mid;
        }

        if(matrix[low / cols][low % cols] == target || matrix[high / cols][high % cols] == target){
            return true;
        }

        return false;

    }
}
