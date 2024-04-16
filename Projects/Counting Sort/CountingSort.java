/**
 * Name : Annanya Jain
 * I pledge my honor that I have abided by the Stevens honor System.
 */


import java.util.Arrays;

/**
 * Counting sort algorithm is being implemented by the class to sort (ascending order) an input array A of integers.
 *
 */
public class CountingSort {
    public static int[] sort(int[] A) {


        /**
         * A is the array A[1..n] to be sorted and has length n. Thus, n stores the length of the array A.
         */
        int n = A.length;

        /**
         * If length of the array is 0 i.e. A is an empty array, it will return an empty array.
         */
        if(n == 0){
           return A;
        }

        /**
         * First, the program initializes k to the value stored in first index of A.
         * Through for loop, the maximum value in the array A is found.
         * Thus, the maximum value in the array A is finally stored in k.
         */
        int k = A[0];

        for(int i= 1; i< n; i++){
            if(A[i] > k){
                k = A[i];
            }
        }

        /**
         * C is a counting array of size k+1 i.e (max value + 1) is the size of C.
         */
        int C[] = new int[k+1];

        /**
         * B is an array B[1..n] that will hold the sorted output.
         */
        int B[] = new int[n];

        /**
         * The array C will have k number of elements initialized to 0.
         */
        for (int i = 0; i <= k; ++i) {
            C[i] = 0;
        }

        /**
         * At each position of the array C, the count of each element in the input array A gets stored.
         */

        for (int j = 0; j < n; j++) {
            C[A[j]] = C[A[j]] + 1;
        }

        /**
         * The program then finds the cumulative count by summing the counts of each element upto the respective elements
         * It then gets stored in each position of array C.
         */

        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        /**
         * We iterate through each element of A in reverse order, and place each element in its sorted position in the
         * output array B, based on its cumulative count in the array C and its index position in array A.
         */

        for (int j = n - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }

        /**
         * The sorted array elements are then stored in the inout array A also.
         */

        for (int i = 0; i < n; i++) {
            A[i] = B[i];
        }

        /**
         * We now return the sorted array B.
         */
        return B;
    }
}
