class Solution {
    public void rotate(int[][] matrix) {
        rotate_(matrix);
    }

    public static void rotate_(int[][] arr) {
        // transpose
        transpose(arr);
        // reverse
        for (int[] is : arr) {
            reverse(is);
        }
    }

    // transpose
    public static void transpose(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    // reverse
    public static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}