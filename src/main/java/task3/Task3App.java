package task3;


import util.DisjointSet;
import util.InputReader;
import util.Pair;

import java.util.List;
import java.util.stream.Stream;

public class Task3App {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        List<Pair<Integer>> vortexPairs = inputReader.readIntPairList();
        inputReader.close();
        int separatedGraphsCount = countSeparatedGraphs(vortexPairs);
        System.out.println(separatedGraphsCount);
    }

    private static int countSeparatedGraphs(List<Pair<Integer>> vortexPairs) {
        if (vortexPairs.isEmpty()) {
            return 0;
        }

        int maxVortex = getMaxVortex(vortexPairs);

        DisjointSet disjointSet = new DisjointSet(maxVortex);

        vortexPairs.forEach(pair -> disjointSet.union(pair.getFirst(), pair.getSecond()));

        long separatedGraphsCount = vortexPairs.stream()
                .flatMap(pair -> Stream.of(pair.getFirst(), pair.getSecond()))
                .distinct()
                .filter(disjointSet::isRepresentative)
                .count();

        // separatedGraphsCount can not be more than 10^6
        return (int) separatedGraphsCount;
    }

    private static int getMaxVortex(List<Pair<Integer>> vortexPairs) {
        return vortexPairs.stream()
                .flatMap(pair -> Stream.of(pair.getFirst(), pair.getSecond()))
                .max(Integer::compareTo)
                .orElseThrow(RuntimeException::new);
    }
}
