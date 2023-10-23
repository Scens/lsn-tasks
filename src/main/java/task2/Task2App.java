package task2;

import util.InputReader;
import util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task2App {
    private static final int SUM = 13;
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        List<Integer> intList = inputReader.readIntListLine();
        inputReader.close();
        List<Pair<Integer>> sumPairs = findSumPairs(intList, SUM);
        printSumPairs(sumPairs);
    }

    private static List<Pair<Integer>> findSumPairs(List<Integer> intList, int sum) {
        List<Integer> sortedArray = intList.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Pair<Integer>> sumPairs = new ArrayList<>();

        int size = sortedArray.size();
        int first = 0;
        int second = size - 1;
        while (first < second) {
            while (sortedArray.get(first) + sortedArray.get(second) > sum) {
                second--;
            }
            if (sortedArray.get(first) + sortedArray.get(second) == sum) {
                sumPairs.add(new Pair<>(sortedArray.get(first), sortedArray.get(second)));
            }
            first++;
        }

        return sumPairs;
    }

    private static void printSumPairs(List<Pair<Integer>> sumPairs) {
        System.out.println(sumPairs.stream()
                .map(Pair::toString)
                .collect(Collectors.joining("\n")));
    }
}
