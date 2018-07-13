package others;

/**
 * Created by yehuixiang on 6/28/18.
 */
public class QuickSort {
    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);

            quickSort(nums, low, p-1);
            quickSort(nums, p + 1, high);
        }
    }

    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (nums[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;
        return i + 1;
    }

    public void iteration(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }


    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 5, 7, 9, 8, 6, 4, 2, 0};

        QuickSort test1 = new QuickSort();
        test1.quickSort(test, 0, 9);
        test1.iteration(test);
    }
}
