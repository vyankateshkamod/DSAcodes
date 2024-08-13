//Given a sorted and rotated array A of number dinstinct elements which is rotated at some point , and given and element key .
//the task is to find the index of the given element key in the array A.

public class SearchInRotatedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[] { 5, 6, 7, 8, 9, 10,11,12,13, 1, 2, 3 }, 0, 11, 10));
    }

    private static int search(int[] arr, int l, int r, int key) {
        int pivot = getPivot(arr, l, r);
        System.out.println("Pivot is at index : "+pivot);
        int e = binarySearch(arr, l, pivot, key);
        if (e == -1) {
            e = binarySearch(arr, pivot + 1, r, key);
        }
        return e ;
    }

    private static int getPivot(int[] arr, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[mid] > arr[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            System.out.println("Key is at index : "+mid) ;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int l, int r, int key) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                l = (mid + 1);
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
