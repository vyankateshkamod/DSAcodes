
import java.util.Arrays;

public class CeilTheFloor2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFloorAndCeil(new int[]{3, 4, 7, 8, 8, 10}, 6, 5)));
    }

    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int floor = floor(arr, n, x);
        int ceil = ceil(arr, n, x);
        return new int[] { floor, ceil };
    }

    public static int floor(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int ceil(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

}
