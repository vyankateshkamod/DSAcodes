import java.util.Arrays;

public class Q88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}; 
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    // optimal 2
    // tc : log(m+n) * n + n
    // sc : 1
    public static void merge(int[] arr1, int m, int[] arr2, int n) {

        int len = (m + n);

        int gap = (len / 2) + (len % 2); // to take ceil

        while (gap > 0) { // O(log(m+n))
            int left = 0;
            int right = left + gap;
            while (right < len) { // O(m+n)
                // arr1 and arr2
                if (left < m && right >= m) {
                    swapIfGreater(arr1, arr2, left, right - m);
                }
                // arr2 and arr2
                else if (left >= m) {
                    swapIfGreater(arr2, arr2, left - m, right - m);
                }
                // arr1 and arr1
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }

        for (int i = 0; i < n; i++) { // O(n)
            arr1[m + i] = arr2[i];
        }
    }

    public static void swapIfGreater(int[] arr1, int[] arr2, int idx1, int idx2) {
        if (arr1[idx1] > arr2[idx2]) {
            int temp = arr1[idx1];
            arr1[idx1] = arr2[idx2];
            arr2[idx2] = temp;
        }

    }

    // optimal 1
    // tc : min(m,n) + n + (m+n)log(m+n)
    // sc : 1
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int left = m - 1;
        int right = 0;

        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    // brute
    // tc : 2(m+n)
    // sc : m + n
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[n + m];
        int left = 0;
        int right = 0;
        int index = 0;
        while (left < m && right < n) {
            if (nums1[left] < nums2[right]) {
                arr[index] = nums1[left];
                left++;
            } else {
                arr[index] = nums2[right];
                right++;
            }
            index++;
        }

        while (left < m) {
            arr[index] = nums1[left];
            index++;
            left++;
        }

        while (right < n) {
            arr[index] = nums2[right];
            index++;
            right++;
        }

        for (int i = 0; i < (m + n); i++) {
            nums1[i] = arr[i];
        }
    }
}
