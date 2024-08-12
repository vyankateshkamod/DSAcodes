//Given an array of size N. The task is to left rotate array by D elements where D<=N
//Expected time complexity : O(N)
//Expected Auxiliary Space : O(1)

public class RotateArray2 {

    public static void main(String[] args) {
        rotateArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5);
    }

    private static void rotateArray(int[] arr, int D) {
        int[] arrA = new int[D + 1];
        int[] arrB = new int[(arr.length-1) - D];

        for (int i = 0; i <= D; i++) {
            arrA[i] = arr[i];
        }

      
        for (int j = D + 1 , l = 0; j <= arr.length - 1; j++ , l++) {
           
                arrB[l] = arr[j];
          
        }
        

        int[] arrRotate = new int[arrB.length + arrA.length];
        System.arraycopy(arrB, 0, arrRotate, 0, arrB.length);
        System.arraycopy(arrA, 0, arrRotate, arrB.length, arrA.length);
        for (int k : arrRotate) {
            System.out.print(k + " ");
        }

    }

}
