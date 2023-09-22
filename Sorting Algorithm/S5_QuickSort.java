import java.util.Arrays;

public class S5_QuickSort {
    public static void main(String[] args) {

        int[] arr = {11, 3, -2, 4, 0, -10};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] nums, int low, int high) {
        if (low >= high)
            return;

        int start = low;
        int end = high;
        int middle = start + (end - start) / 2;
        int pivot = nums[middle];

        while (start <= end) {
            while (nums[start] < pivot) {
                start++;
            }
            while (nums[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        // NOW PIVOT IS AT CORRECT INDEX, SORT THE TWO HALVES
        quickSort(nums, low, end);
        quickSort(nums, start, high);
    }
}


/*
* Take a random pivot element and make sure the elements left side of the pivot element are smaller than the pivot value and
* elements on the right hand side are greater than the pivot element
* Unstable Algorithm
* Use Hybrid Sorting Algorithm (Tim Sort) : Merge Sort + Insertion Sort
 */