package kotlinlang

import kotlin.math.max

/**
 * Given two n sized arrays A and B storing n bit numbers in binary form, write an algorithm to add A and B and store the result in array C of size n + 1

A[1....n]
B[1....n]

for 0<=i <= n
A[i] = 0 or 1, B[i] = 0 or 1

carryOver = 0
for i from n-1 to 0:
sum = a[i] + b[i] + carryOver
if sum = 0, c[i+1] = 0, carryOver = 0
if sum = 1, c[i+1] = 1, carryOver = 0
if sum = 2, c[i+1] = 1, carryOver = 1
c[0] = carryOver
 
 */

fun binaryAddition(a: Array<Int>, b: Array<Int>) : Array<Int>{
    var resultSize = max(a.size, b.size) + 1
    val result = Array(resultSize) { 0 }
    var carryOver = 0
    var aIndex = a.size - 1
    var bIndex = b.size - 1
    while(aIndex >= 0 || bIndex >= 0 || carryOver > 0){
        val aBit = if(aIndex>=0) a[aIndex] else 0
        val bBit = if(bIndex>=0) b[bIndex] else 0
        var sum = aBit + bBit + carryOver
        result[resultSize - 1] = sum % 2
        carryOver = sum / 2
        aIndex--
        bIndex--
        resultSize--
    }
    return result
}

fun main() {
    val a = arrayOf(1,0,1,1,0,0,1,1,1)
    val b = arrayOf(1,1,1,1,1,1,1)
    val result = binaryAddition(a,b)
    a.forEach(::print)
    println()
    b.forEach(::print)
    println()
    result.forEach(::print)
}