
import java.util.Arrays;

public class S1_BubbleSort {
    public static void main(String[] args) {
        int[] nums = {11, -2, 4, 0, -10};
        bubblesSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void bubblesSort(int[] arr) {
        boolean swap;
        for (int i=0; i<arr.length; i++) {
            swap = false;
            for (int j=1; j<arr.length-i; j++) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swap = true;
                }
            }
            // IF SWAP WAS NOT PERFORMED FOR A PARTICULAR VALUE OF i, THEN IT MEANS THE ARRAY IS ALREADY SORTED SO STOP THE PROGRAM
            if (!swap) break;
        }
    }
}

/*
    Bubble sort is comparing the current element with the next element and swapping if the next element is higher than the current element.
    Also known as Sinking Sort or Exchange sort
    Time Complexity : Best Case -> O(N)
                      Worst Case -> O(N pow(2))
    Space Complexity : O(1) -> No extra array needs to be created since it can be sorted or modified in itself
                                and so it is also called as INPLACE SORTING ALGORITHM
*/