package leetcode.BinarySearch.二维二分法;

/**
 * Created by yehuixiang on 9/2/18.
 */
public class KthSmallestElementInASortedMatrix_378 {
    // public int kthSmallest(int[][] matrix, int k) {
    //     int n = matrix.length;
    //     PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
    //         @Override
    //         public int compare(Integer a, Integer b) {
    //             return b - a;
    //         }
    //     });
    //     int count = 0;
    //     for (int i = 0; i <= n - 1; i++) {
    //         for (int j = 0; j <= n - 1; j++) {
    //             if (count < k) {
    //                 count ++;
    //                 pq.offer(matrix[i][j]);
    //             }else {
    //                 if (pq.peek() > matrix[i][j]) {
    //                     pq.poll();
    //                     pq.offer(matrix[i][j]);
    //                 }
    //             }
    //         }
    //     }
    //     return pq.peek();
    // }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            int count = count(matrix, mid);
            if (count < k) {
                low = mid;
            }else {
                high = mid;
            }
        }

        if(count(matrix,low) < k){
            return high;
        }

        return low;
    }

    public int count(int[][] matrix, int target) {
        int n = matrix.length, r = n - 1, c = 0;
        int sum = 0;
        while (r >= 0 && c <= n - 1) {
            if (matrix[r][c] > target) r --;
            else {
                c ++;
                sum += r + 1;
            }
        }
        return sum;
    }
}
