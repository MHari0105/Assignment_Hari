
import java.util.Arrays;

public class S2_SelectionSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 4};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void selectionSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int lastIndex = arr.length - 1 - i;
            int maxIndex = getMaxIndex(arr, 0, lastIndex);
            swap(arr, maxIndex, lastIndex);
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int maxIndex = start;
        for (int i=start; i<=end ; i++) {
            if (arr[maxIndex] < arr[i])
                maxIndex = i;
        }
        return maxIndex;
    }
}

/*
* Selection sort is choosing the highest element from the array and assigning it in the correct index (last index) (Descending) or
    Choose the minimum value from the array and assign it in its correct position (Ascending)
* Time Complexity : Worst Case -> O(N, pow2)
                    Best Case -> O(N, pow2)
 */

