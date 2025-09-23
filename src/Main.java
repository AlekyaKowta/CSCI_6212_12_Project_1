package src;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Selecting random values of n
        int[] nValues = {10, 50, 100, 200, 400, 800, 1600};

        // Printing the time in ms against the n values
        System.out.println("n,time_ms");

        for (int n : nValues) {
            long startTime = System.nanoTime();
            calculateSum(n);
            long endTime = System.nanoTime();

            long durationMs = (endTime - startTime) / 1000000;
            System.out.println(n + "," + durationMs);
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