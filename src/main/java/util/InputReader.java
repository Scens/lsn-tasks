package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    private final Scanner sc = new Scanner(System.in);

    public List<Integer> readIntListLine() {
        String line = sc.nextLine();
        String[] numbers = line.split(" ");

        List<Integer> intArray = new ArrayList<>(numbers.length);

        for (String number : numbers) {
            Integer parsedInt = Integer.parseInt(number);
            intArray.add(parsedInt);
        }

        return intArray;
    }

    public int readInt() {
        return sc.nextInt();
    }

    public Pair<Integer> readIntPair() {
        Integer first = sc.nextInt();
        Integer second = sc.nextInt();
        return new Pair<>(first, second);
    }

    public List<Pair<Integer>> readIntPairList() {
        int size = readInt();
        List<Pair<Integer>> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            Pair<Integer> intPair = readIntPair();
            list.add(intPair);
        }

        return list;
    }

    public void close() {
        sc.close();
    }
}
