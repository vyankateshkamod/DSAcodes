public class BinarySearch {
    public static void main(String[] args) {
        int index = binarySearch(new int[]{3,4,12,16,23,43}, 23) ;
        System.out.print(index);
    }

    private static int binarySearch(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (x < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
