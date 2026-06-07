public class SearchInSortedMat {
    public static boolean searchMat(int arr[][], int key) {
        int col = 0;
        int row = arr[0].length - 1;

        while (col <= arr.length - 1 && row >= 0) {
            if (arr[row][col] == key) {
                System.out.println("found at index (" + row + " ," + col + ")");
                return true;
            } else if (key < arr[row][col]) {
                // move top
                row--;
            } else {
                // move right
                col++;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int arr[][] = { 
        { 10, 20, 30, 40 }, 
        { 15, 25, 35, 45 }, 
        { 27, 29, 37, 48 }, 
        { 32, 33, 39, 50 } };
        boolean foundOrNot = searchMat(arr, 50);
        System.out.println(foundOrNot);
    }
}
