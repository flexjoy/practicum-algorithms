package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    private static Double[] movingAverage(int n, int[] arr, int windowSize) {
        var result = new Double[n - windowSize + 1];
        long currentSum = 0;

        for (int i = 0; i < windowSize; i++) {
            currentSum += arr[i];
        }

        result[0] = (double) currentSum / windowSize;

        for (int i = windowSize; i < n; i++) {
            currentSum += arr[i] - arr[i - windowSize];
            result[i - windowSize + 1] = (double) currentSum / windowSize;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            var arr = readData(reader);
            int windowSize = readInt(reader);
            var result = movingAverage(n, arr, windowSize);

            var builder = new StringBuilder();
            for (Double v : result) {
                builder
                        .append(v)
                        .append(" ");
            }
            System.out.println(builder);
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static int[] readData(BufferedReader reader) throws IOException {
        var strings = reader.readLine().split(" ");
        var arr = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        return arr;
    }
}
