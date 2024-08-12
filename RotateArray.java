public class RotateArray {
    public static void main(String[] args) {
        rotateArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 4);
    }

    private static void rotateArray(int[] arr, int D) {
        int[] arrA = new int[D+1];
        int[] arrB = new int[9];
        for (int i = 0; i <= arr.length-1 ; i++) {
            if (i == D) {
                for (int j = 0; j <= D; j++) {
                    arrA[j] = arr[j];
                }
                for (int j = D+1; j <= arr.length-1; j++) {
                    for(int l =0 ; l<arr.length ; l++){
                        arrB[l] = arr[j];
                    }
                }
                int[] arrRotate = new int[arrB.length + arrA.length];
                System.arraycopy(arrB, 0, arrRotate, 0, arrB.length);
                System.arraycopy(arrA, 0, arrRotate, arrB.length, arrA.length);
                for (int k : arrRotate) {
                    System.out.print(k + " ");
                }
            }
        }
    }
}
