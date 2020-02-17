package Round_1A_A_2008.src;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumScalarProduct {
    public String findMinimumScalarProduct(int[] listOne, int[] listTwo) {
        List<Integer> l1 = Arrays.stream(listOne).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(listTwo).boxed().collect(Collectors.toList());

        long sum = 0;

        while (l1.size() > 0 && l2.size() > 0) {
            int largest = largestInList(l2);
            int smallest = smallestInList(l1);
            sum += (long) largest * (long) smallest;
            l2.remove(Integer.valueOf(largest));
            l1.remove(Integer.valueOf(smallest));
        }

        return Long.toString(sum);
    }

    private int largestInList(List<Integer> list) {
        return list.stream().max(Integer::compareTo).get();
    }

    private int smallestInList(List<Integer> list) {
        return list.stream().min(Integer::compareTo).get();
    }
}
