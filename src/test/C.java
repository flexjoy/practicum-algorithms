package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C {
    private static List<Double> movingAverage(int n, List<Integer> arr, int windowSize) {
        var result = new ArrayList<Double>();
        long currentSum = 0;

        for (int i = 0; i < windowSize; i++) {
            currentSum += arr.get(i);
        }

        result.add((double) currentSum / windowSize);

        for (int i = windowSize; i < n; i++) {
            currentSum += arr.get(i) - arr.get(i - windowSize);
            result.add((double) currentSum / windowSize);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in));
             var writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            var arr = readList(reader);
            int windowSize = readInt(reader);
            var result = movingAverage(n, arr, windowSize);

            for (double elem : result) {
                writer.write(elem + " ");
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
