package src;

import java.util.Random;

/**
 * This class demonstrates measuring experimental and theoretical
 * run times of a cubic complexity function using arrays with random values.
 * It scales theoretical times to compare with experimental O(n^3) times.
 *
 * @author Alekya Kowta
 * @version 1.0
 * @reviewer Jay Parmar
 */
public class Main {

    /**
     * Main driver method. Runs experiments for various input sizes n,
     * measuring the time taken by calculateSum and compares with
     * theoretical cubic time complexity.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Selecting random values of n for graph plots
        int[] nValues = {2, 10, 50, 75, 100, 200, 225, 400, 450, 500, 600, 750, 800, 1200, 1600, 1800, 2200, 2400, 4000, 6000};

        // Scaling the theoretical time so that the graph is more meaningful
        int nNormalizedValue = 2400;
        double normalizationTimeNs = 399 * 1000000; // Experimental Time for n = 2400

        // Assuming T(n) = c * n ^ 3
        // Calculate c as Experimental Time / Theoretical Value
        double scalingFactor = normalizationTimeNs / Math.pow(nNormalizedValue, 3);

        // Printing the time in ns and adjusted time
        System.out.println("n, experimental_time_ns, theoretical_time, adjusted_theoretical_time");

        for (int n : nValues) {
            long startTime = System.nanoTime();
            calculateSum(n);
            long endTime = System.nanoTime();

            // Measured experimental time
            long durationNs = (endTime - startTime);
            // Theoretical cubic calculation
            long theoreticalDuration = (long) Math.pow(n, 3);
            // Scaled theoretical time
            double adjustedTheoreticalTime = scalingFactor * Math.pow(n, 3);

            System.out.println(n + "," + durationNs + "," + theoreticalDuration + "," + adjustedTheoreticalTime);
        }
    }

    /**
     * Method of the given program to analyze.
     * Performs a cubic complexity sum of triplet products from
     * three randomly initialized arrays of size n+1.
     * Contains a nested loop with early termination conditionß.
     *
     * @param n size parameter for arrays and loops
     * @return the sum as a long value of products of elements in arrays a, b, and c
     */
    public static long calculateSum(int n){
        long sum = 0;

        // Initialize arrays with random values
        Random random = new Random();

        int[] a = new int[n+1];
        int[] b = new int[n+1];
        int[] c = new int[n+1];

        for (int i = 1; i <= n; i++){
            a[i] = random.nextInt(10);
            b[i] = random.nextInt(10);
            c[i] = random.nextInt(10);
        }

        // Given program
        for (int i = 1; i <= n; i++){
            for(int j = i; j <= n; j++){
                for (int k = j; k <= n; k++){
                    sum += (long) a[i] * b[j] * c[k];
                }
                if (j == 2*i){
                    j = n;
                }
            }
        }
        return sum;
    }
}