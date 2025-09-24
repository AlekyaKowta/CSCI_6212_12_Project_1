package src;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Selecting random values of n
        int[] nValues = {2, 10, 50, 75, 100, 200, 225, 400, 450, 500, 600, 750, 800, 1600, 2400, 6000};

        //Scaling the N so that the graph is more meaningful

        int nNormalizedValue = 2400;
        double normalizationTimeNs = 399 * 1000000; // Experimental Time for n = 2400

        // Assuming T(n) = c * n ^ 3
        // Calculate c as Experimental Time / Theoretical Value
        double scalingFactor = normalizationTimeNs / Math.pow(nNormalizedValue, 3);

        // Printing the time in ms against the n values
        System.out.println("n, time_ns, theoretical_time, adjusted_theoretical_time");

        for (int n : nValues) {
            long startTime = System.nanoTime();
            calculateSum(n);
            long endTime = System.nanoTime();

            long durationNs = (endTime - startTime);
            long theoreticalDuration = (long) Math.pow(n, 3);
            double adjustedTheoreticalTime = scalingFactor * Math.pow(n, 3);

            System.out.println(n + "," + durationNs + "," + theoreticalDuration + "," + adjustedTheoreticalTime);
        }
    }

    // Code for the program to be analyzed
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