import java.util.ArrayList;

public class Q493 {
    public static void main(String[] args) {
        int[] arr = {2,4,3,5,1} ;
        System.out.println(reversePairs(arr));
    }

    // optimal
    // tc : 2n * logn
    // sc : n
    public static int reversePairs(int[] arr) {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }

    static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return cnt;
    }

    static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2L * arr[right])
                right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // brute
    // tc : n2
    // sc : 1
    public int reversePairs2(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > (2L * arr[j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
