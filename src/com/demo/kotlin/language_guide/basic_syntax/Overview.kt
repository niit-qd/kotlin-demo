// [Overview](https://kotlinlang.org/docs/basic-syntax.html)

package com.demo.kotlin.language_guide.basic_syntax

import kotlin.text.*


// -------------------------------------------------------
// Program entry point
// Print to the standard output
// -------------------------------------------------------

// 如果同时存在无参main和有参main，优先使用有参main。
//fun main() {
//    println("Hello World!")
//}
// 实际返回类型是Unit
//fun main(): Unit {
//    println("Hello World! 01")
//}

// 有参main只能是String数组
//fun main(args: Array<String>) {
//    println("Hello World! 02")
//}

// Int类型，非法
//fun main(args: Array<Int>) {
//    println("Hello World! 03")
//}

// -------------------------------------------------------
// Read from the standard input
// -------------------------------------------------------

//fun main(args: Array<String>) {
//    println("please input something :)")
//    val word = readln()
//    println("word is $word")
//}

// -------------------------------------------------------
// Functions
// -------------------------------------------------------

fun sum1(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun printSum1(a: Int, b: Int): Unit {
    println("a=$a, b=$b, sum = ${a + b}")
}

fun printSum2(a: Int, b: Int) {
    println("a=$a, b=$b, sum = ${a + b}")
}

//fun main(args: Array<String>) {
//    println("sum1 = ${sum1(1, 2)}")
//    println("sum2 = ${sum2(2, 3)}")
//    printSum1(10, 20)
//    printSum2(10, 20)
//}

// -------------------------------------------------------
// Variables
// -------------------------------------------------------

val PI: Float = 3.14F
var v: Float = 1.000F


fun testVariables() {
    val x: Int = 5
    var y: Int = 5
    y += 1
    var z = 6
    z -= 2
    // z="" // error
    println("x=$x, y=$y, z=$z")
    println("PI = $PI, v = $v")
}

//fun main(args: Array<String>) {
//    testVariables()
//}

// -------------------------------------------------------
// Creating classes and instances
// -------------------------------------------------------

// 默认为final，不显示注明open，报错：Kotlin: This type is final, so it cannot be extended.
open class Shape

class Rectangle(val height: Double, val length: Double) : Shape() {
    val perimeter = (height + height) * 2
}

//fun main(args: Array<String>) {
//    val rect = Rectangle(5.5, 7.7)
//    println("The perimeter is ${rect.perimeter}")
//}

// -------------------------------------------------------
// Comments
// -------------------------------------------------------

// This is an end-of-line comment

/* This is a block comment
   on multiple lines. */

/* The comment starts here
/* contains a nested comment */
and ends here. */

// -------------------------------------------------------
// String templates
// -------------------------------------------------------

fun testStringTemplate() {
    var a = 1
    val s1 = "a is $a"
    println(s1)

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

//fun main(args: Array<String>) {
//    testStringTemplate()
//}

// -------------------------------------------------------
// Conditional expressions
// -------------------------------------------------------

fun maxOf1(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOf2(a: Int, b: Int) = if (a > b) a else b

//fun main(args: Array<String>) {
//    println("maxOf1(5, 7) is (${maxOf1(5, 7)})")
//    println("maxOf2(11, 2) is (${maxOf2(11, 2)})")
//}

// -------------------------------------------------------
// for loop
// -------------------------------------------------------

fun testFor() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

//fun main(args: Array<String>) {
//    testFor()
//}

// -------------------------------------------------------
// while  loop
// -------------------------------------------------------

fun testWhile() {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

//fun main(args: Array<String>) {
//    testWhile()
//}

// -------------------------------------------------------
// when expression
// -------------------------------------------------------

fun describe(obj: Any?): String =
    when (obj) {
        6 -> "Saturday"
        "play" -> "Sunday"
        is Long -> "Long Long Ago"
        !is String -> "Not a string"
        else -> "Unknown"
    }

//fun main(args: Array<String>) {
//    println(describe(6))
//    println(describe(true))
//    println(describe("Hello"))
//}

// -------------------------------------------------------
// Ranges
// -------------------------------------------------------

fun testRanges1(start: Int, end: Int, value: Int) {
    if (value in start..end) {
        println("start=$start, end=$end, value:$value is in ranges[$start, $end]")
    } else {
        println("start=$start, end=$end, value:$value is not in ranges[$start, $end]")
    }
}

fun testRanges2() {
    val list = listOf("apple", "banana", "kiwi")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range")
    }
    if (2 in list.indices) {
        println("2 is in valid list indices range")
    }
}

fun iterateRange() {
    for (index in 0..5) {
        println("index is $index")
    }
    for (index in 8..15 step 2) {
        println("index is $index")
    }
    for (index in 100 downTo 90 step 3) {
        println("index is $index")
    }
}

//fun main(args: Array<String>) {
//    testRanges1(10, 20, 5)
//    testRanges1(10, 20, 15)
//    testRanges2()
//    iterateRange()
//}

// -------------------------------------------------------
// Collections
// -------------------------------------------------------

//fun main(args: Array<String>) {
//    val items = listOf("apple", "banana", "kiwi")
//    for (item in items) {
//        println(item)
//    }
//}

//fun main(args: Array<String>) {
//    val items = setOf("apple", "banana", "kiwi")
//    when {
//        // 如果有多个子句满足条件，则只有第一个子句会被执行
//        "orange" in items -> println("juicy")
//        "apple" in items -> println("apple is fine too")
//        "banna" in items -> println("banana is fine too")
//    }
//}

//fun main() {
//    val fruits = listOf("banana", "avocado", null, "apple", "kiwi", "orange")
//    fruits
//        .filter { null != it && it.contains("a") }
//        .filter { null != it && it.length > 5 }
//        .sortedBy { it }
//        .map { it?.uppercase() }
//        .forEach { println(it) }
//}

// -------------------------------------------------------
// Nullable values and null checks
// -------------------------------------------------------

fun parseInt(str: String?): Int? {
    return str?.toIntOrNull()
}

fun printProduct(arg1: String?, arg2: String) {
    val x: Int? = parseInt(arg1)
    val y = parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println("$arg1 or $arg2 is not a number")
    }
}

//fun main(args: Array<String>) {
//    printProduct("2", "3")
//    printProduct("a", "b")
//    printProduct(null, "5")
//    // printProduct("4", null)
//}

// -------------------------------------------------------
// Type checks and automatic casts
// -------------------------------------------------------


fun getObjLength(obj: Any?): Int? {
    if (obj == null) {
        return null
    }
    if (obj is Int) {
        var obj2 = obj
        var bitCount: Int = 0
        while (obj2 != 0) {
            bitCount++
            obj2 /= 10
        }
        return bitCount
    }
    if (obj is String) {
        return obj.length
    }
    return null
}

fun main() {
    println(getObjLength("apple"))
    println(getObjLength(23))
    println(getObjLength(-123))
    println(getObjLength(null))
    println(getObjLength(123.4))
    println(getObjLength(listOf(1, 2, 3, 4)))
    println(getObjLength(listOf(Any())))
}
