import java.util.Arrays;

public class S4_MergeSortInPlace {
    public static void main(String[] args) {
        int[] nums = {8, 7, 12, 4, 20, 5};
        mergeSortInPlace(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    static void mergeSortInPlace(int[] arr, int start, int end) {
        if (end - start == 1)
            return;

        int middle = (start+end)/2;

        mergeSortInPlace(arr, start, middle);
        mergeSortInPlace(arr, middle, end);

        mergeInPlace(arr, start, middle, end);
    }

    private static void mergeInPlace(int[] arr, int start, int middle, int end) {
        int i = start;
        int j = middle;
        int k = 0;
        int[] mixArr = new int[end - start];

        while (i < middle && j < end) {
            if (arr[i] < arr[j]) {
                mixArr[k] = arr[i];
                i++;
            }
            else {
                mixArr[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < middle) {
            mixArr[k] = arr[i];
            i++;
            k++;
        }

        while (j < end) {
            mixArr[k] = arr[j];
            j++;
            k++;
        }

        for (int index=0; index < mixArr.length; index++) {
            arr[start + index] = mixArr[index];
        }
    }
}
