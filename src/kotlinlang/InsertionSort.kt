package kotlin

import java.util.stream.IntStream
import kotlin.random.Random

fun sort(numbers : MutableList<Int>) {
    var startingIndex = 1
    while(startingIndex <= numbers.size){
        var sortedIndex = startingIndex - 1
        val key = numbers[startingIndex]
        while(sortedIndex >= 0 && numbers[sortedIndex] > key){
            numbers[sortedIndex + 1] = numbers[sortedIndex]
            numbers[sortedIndex] = key
            sortedIndex--
        }
        startingIndex++
    }
}

fun main() {
    val list = IntStream.range(1,10).map { Random.nextInt()%100 }.boxed().toList()
    print(list)
    sort(list)
    print(list)
}