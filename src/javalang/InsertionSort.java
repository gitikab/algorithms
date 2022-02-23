package javalang;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Insertion sort is just like sorting cards by picking up a card from a deck on the table.
 * When first card is picked, it is the sorted card in the left hand.
 * When a second card is picked, it is inserted at a position in the left hand such that the cards in the
 * left hand are always in sorted order.
 * <p>
 * Cards on the table : [7, 5, 6, 2, 8, 3, 3]
 * Cards in the left hand after each card is picked:
 * [7]
 * [5, 7]
 * [5, 6, 7]
 * [2, 5, 6, 7]
 * [2, 5, 6, 7, 8]
 * [2, 3, 5, 6, 7, 8]
 * [2, 3, 3, 5, 6, 7, 8]
 */

public class InsertionSort {

    public static void sort(List<Integer> input, Boolean descending) {
        // Starting from second element
        int currentIndex = 1;
        while (currentIndex <= input.size() - 1) {
            int key = input.get(currentIndex);
            int lastSortedIndex = currentIndex - 1;
            while (lastSortedIndex >= 0 && buildCondition(key, input.get(lastSortedIndex), descending)) {
                input.set(lastSortedIndex + 1, input.get(lastSortedIndex)); //Shift element to the right
                lastSortedIndex--;
            }
            input.set(lastSortedIndex + 1, key); //insert key once position is found
            currentIndex++;
        }
    }

    private static boolean buildCondition(Integer key, Integer lastSortedValue, Boolean descending){
        if(descending)
            return key > lastSortedValue;
        else
            return key < lastSortedValue;
    }

    public static void main(String[] args) {
        List<Integer> input = IntStream.rangeClosed(1 , 10).boxed()
                .map(operand -> new Random().nextInt() % 100)
                .collect(Collectors.toList());

        System.out.println(input);

        List<Integer> expectedOutputAscending = input.stream().sorted().toList();
        List<Integer> expectedOutputDescending = input.stream().sorted((o1, o2) -> o2.compareTo(01)).toList();
        sort(input, false);
        System.out.println(input);
        assert(input.equals(expectedOutputAscending));
        sort(input, true);
        System.out.println(input);
        assert(input.equals(expectedOutputDescending));

    }
}
