import java.util.Arrays;

public class S4_MergeSort {

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 3, 2, 1};
        nums = mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1)
            return arr;

        int mid = arr.length/2;

        int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] rightArr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(leftArr, rightArr);
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        int i=0, j=0, k=0;
        int[] mixArr = new int[leftArr.length + rightArr.length];

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                mixArr[k] = leftArr[i];
                i++;
            }
            else {
                mixArr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length) {
            mixArr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArr.length) {
            mixArr[k] = rightArr[j];
            j++;
            k++;
        }

        return mixArr;
    }
}

/*
 * Divide the array into half and sort first half of the array and sort second half of the array and merge at last
 * Time Complexity - O (N * logN)
 */