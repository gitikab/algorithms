package kotlinlang

import kotlin.random.Random

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

fun sort(numbers : MutableList<Int>) {
    var currentIndex = 1
    while(currentIndex < numbers.size){
        var lastSortedIndex = currentIndex - 1
        val key = numbers[currentIndex]
        while(lastSortedIndex >= 0 && numbers[lastSortedIndex] > key){
            numbers[lastSortedIndex + 1] = numbers[lastSortedIndex]
            lastSortedIndex--
        }
        numbers[lastSortedIndex + 1] = key
        currentIndex++
    }
}

fun main() {
    val input = MutableList(10) { Random.nextInt() % 100 }
    println(input)
    val expectedOutput = input.sorted()
    sort(input)
    println(input)
    assert(expectedOutput == input)
}