package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class B {
    private static List<Integer> zip(List<Integer> a, List<Integer> b) {
        var result = new ArrayList<Integer>();

        var iteratorA = a.iterator();
        b.forEach(i -> {
            result.add(iteratorA.next());
            result.add(i);
        });

        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> a = readList(reader);
            List<Integer> b = readList(reader);
            printList(zip(a, b));
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static <T> void printList(List<T> list) {
        var s = list.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" "));
        System.out.println(s);
    }
}
