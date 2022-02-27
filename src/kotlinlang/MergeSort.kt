package kotlinlang

/**
 * The merge sort algorithm closely follows the divide-and-conquer paradigm. It operates as follows:
 * Divide: Divide the n-element sequence to be sorted into two subsequences of n=2 elements each.
 * Conquer: Sort the two subsequences recursively using merge sort.
 * Combine: Merge the two sorted subsequences to produce the sorted answer.
 * The recursion “bottoms out” when the sequence to be sorted has length 1,
 * in which case there is no work to be done, since every sequence of length 1 is already in sorted order.
 * We merge by calling an auxiliary procedure MERGE(A,p,q,r),
 * where A is an array and p, q, and r are indices into the array such that p 􏰎 q < r.
 * The procedure assumes that the subarrays A[ p...q ] and A[ q+1...r ]􏰀 are in sorted order.
 * It merges them to form a single sorted subarray that replaces the current subarray A[ p...r ]
 */

fun mergeSort(input: Array<Int>, startIndex: Int, stopIndex: Int){
    if(startIndex < stopIndex){
        val splitIndex = (startIndex + stopIndex)/2
        mergeSort(input,startIndex, splitIndex)
        mergeSort(input, splitIndex+1, stopIndex)
        merge(input, startIndex, splitIndex, stopIndex)
    }
}

fun merge(input: Array<Int>, startIndex: Int, splitIndex: Int, stopIndex: Int){
    val sortedInput1Size = splitIndex - startIndex + 1
    val sortedInput2Size = stopIndex - splitIndex
    val sortedInput1 = Array(sortedInput1Size) { i -> input[startIndex + i] }
    val sortedInput2 = Array(sortedInput2Size) { i -> input[splitIndex + 1 + i] }
    var index1 = 0
    var index2 = 0
    for(index in IntRange(startIndex, stopIndex)){
        if(index2 >= sortedInput2.size || (index1 < sortedInput1.size && sortedInput1[index1] < sortedInput2[index2])){
            input[index] = sortedInput1[index1]
            index1++
        }else{
            input[index] = sortedInput2[index2]
            index2++
        }
    }
}

fun main() {
    val input = arrayOf(33, 12, 17, 6, 2, 25, 22, 10)
    input.forEach{ print("$it ")}
    println()
    mergeSort(input, 0, input.size - 1)
    input.forEach{ print("$it ")}
}