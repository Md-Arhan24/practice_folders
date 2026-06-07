public class GetMinAndMax {
    public static int[] getminandmax(int arr[]) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }

        }
        int newArr[] = { min, max };
        return newArr;

    }

    public static void main(String[] args) {
        int arr[] = { 2192, 13849, 3443, 20919, 10086, 31384, 4405 };
        int ans[] = getminandmax(arr);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
