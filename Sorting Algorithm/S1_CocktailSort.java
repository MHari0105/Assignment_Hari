import java.util.Arrays;

public class S1_CocktailSort {
    public static void main(String[] args) {

        int[] arr = {11, -2, 4, 0, -10};
        cocktailSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cocktailSort(int[] arr) {

        int start = 0, end = arr.length-1;
        while (start < end) {
            swapMax(arr, start, end);
            end--;
            swapMin(arr, start, end);
            start++;
        }
    }

    private static void swapMax(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        int temp = max;
        arr[index] = arr[end];
        arr[end] = temp;
    }

    private static void swapMin(int[] arr, int start, int end) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        int temp = min;
        arr[index] = arr[start];
        arr[start] = temp;
    }
}
