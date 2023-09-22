import java.util.Arrays;

public class S3_InsertionSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 2, -3};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void insertionSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j>0; j--) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                else break;
            }
        }
    }
}

/*
* After first pass i.e. i=0 first two index is sorted
* After second pass i.e. i=1 first three index is sorted, goes on
* Time complexity : Worst Case -> O(N pow2)
                    Best case -> O(N)
* Adaptive : No of swaps reduced when compared to Bubble sort
* Stable
* Good to use when arrays are partially sorted, when size of array is small
 */