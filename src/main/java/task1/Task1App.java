package task1;

import util.InputReader;

import java.util.List;
import java.util.stream.Collectors;

public class Task1App {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        List<Integer> intList = inputReader.readIntListLine();
        inputReader.close();
        printCalculations(intList);
    }

    private static void printCalculations(List<Integer> intList) {
        int count = intList.size();

        List<Integer> sortedDistinctList = intList.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        int distinct = sortedDistinctList.size();
        int min = sortedDistinctList.get(0);
        int max = sortedDistinctList.get(distinct - 1);

        System.out.println(sortedDistinctList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

        System.out.println("count: " + count);
        System.out.println("distinct: " + distinct);
        System.out.println("min: " + min);
        System.out.println("max: " + max);
    }
}
