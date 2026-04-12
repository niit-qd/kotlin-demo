package com.demo.kotlin.language_guide.types

// [Numbers](https://kotlinlang.org/docs/numbers.html)

import com.demo.kotlin.language_guide.isTypeOf
import kotlin.reflect.typeOf

// [Numbers](https://kotlinlang.org/docs/numbers.html)

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Numbers
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// -------------------------------------------------------
// Integer types
// -------------------------------------------------------

//fun main() {
//    println("Byte.MIN_VALUE is ${Byte.MIN_VALUE}, Byte.MAX_VALUE is ${Byte.MAX_VALUE}")
//    println("Short.MIN_VALUE is ${Short.MIN_VALUE}, Short.MAX_VALUE is ${Short.MAX_VALUE}")
//    println("Int.MIN_VALUE is ${Int.MIN_VALUE}, Int.MAX_VALUE is ${Int.MAX_VALUE}")
//    println("Long.MIN_VALUE is ${Long.MIN_VALUE}, Long.MAX_VALUE is ${Long.MAX_VALUE}")
//
//    // 默认Int
//    val b = 12
//    val s = 128
//    val i = 32768
//    val l = 2147483648
//    val ll = 32768L
//    println("b is $b, type is ${b.javaClass.simpleName}")
//    println("s is $s, type is ${s.javaClass.simpleName}")
//    println("i is $i, type is ${i.javaClass.simpleName}")
//    println("l is $l, type is ${l.javaClass.simpleName}")
//    println("ll is $ll, type is ${ll.javaClass.simpleName}")
//}

// -------------------------------------------------------
// Floating-point types
// -------------------------------------------------------

fun printFloat(value: Float) {
    println(value)
}

fun printDouble(value: Double) {
    println("$value")
}

//fun main() {
//    println("Float.MIN_VALUE is ${Float.MIN_VALUE}, Float.MAX_VALUE is ${Float.MAX_VALUE}")
//    println("Double.MIN_VALUE is ${Double.MIN_VALUE}, Double.MAX_VALUE is ${Double.MAX_VALUE}")
//
//    val pi = 3.14159
//    println("pi is $pi, type is ${pi.javaClass.simpleName}")
//
//    val double: Double = 3.0
//    println("double is $double, type is ${double.javaClass.simpleName}")
//
//    val float: Float = 3.14159f // F
//    println("float is $float, type is ${float.javaClass.simpleName}")
//
//    printFloat(1.toFloat())
//    printFloat(1.0f)
//    printFloat(1.0.toFloat())
//    printDouble(2.toDouble())
//    printDouble(2.0f.toDouble())
//    printDouble(2.0)
//}

// -------------------------------------------------------
// Floating-point types
// -------------------------------------------------------

//fun main() {
//    val decimal =123
//    val long = 123L
//    val hexadecimal = 0x1112FF0F
//    val binary=0B1110010
//    val double = 123.0
//    val double2=123.456789E3
//    val float = 123.0F
//    println("decimal: $decimal")
//    println("long: $long")
//    println("hexadecimal: $hexadecimal")
//    println("binary: $binary")
//    println("double: $double")
//    println("double2: $double2")
//    println("float: $float")
//
//    val oneMillion = 1_000_000_000L
//    val creditCardNumber = 1234_5678_9012_345678L
//    val socialSecurityNumber = 1234_5678_9012_345678L
//    val hexBytes = 0xFF_EC_DE_5E
//    val bytes = 0b11010010_01101001_10010100_10010010
//    val bigFractional = 1_234_567.7182818284
//    println("oneMillion: $oneMillion")
//    println("creditCardNumber: $creditCardNumber")
//    println("socialSecurityNumber: $socialSecurityNumber")
//    println("hexBytes: $hexBytes")
//    println("bytes: $bytes")
//    println("bigFractional: $bigFractional")
//}

// -------------------------------------------------------
// Boxing and caching numbers on the Java Virtual Machine
// Java虚拟机上的装箱和缓存数字
// -------------------------------------------------------

// -------------------------------------------------------
// The JVM stores numbers as primitive types: `int`, `double`, and so on.
// When you use [generic types](https://kotlinlang.org/docs/generics.html)
// or create a nullable number reference such as `Int?`,
// numbers are boxed in Java classes such as `Integer` or `Double`.
// JVM 将数字存储为基本类型：`int`、`double` 等。
// 当您使用泛型类型或创建可空数字引用（例如 `Int?`）时，
// 数字会被装箱到 Java 类中，例如 `Integer` 或 `Double`。
// -------------------------------------------------------

// -------------------------------------------------------
// The JVM applies a [memory optimization technique](https://docs.oracle.com/javase/specs/jls/se22/html/jls-5.html#jls-5.1.7)
// to `Integer` and other objects that represent numbers between `−128` and `127`.
// All nullable references to such objects refer to the same cached object.
// For example, nullable objects in the following code are [referentially equal](https://kotlinlang.org/docs/equality.html#referential-equality):
// JVM 对 `Integer` 和其他表示 `-128` 到 `127` 之间数字的对象应用了一种内存优化技术。
// 所有指向此类对象的可空引用都指向同一个缓存对象。
// 例如，以下代码中的可空对象在引用上是相等的：
//
// JVM 数字缓存机制
// 为了优化内存和性能，JVM 对 -128 到 127 之间的 Integer（以及 Byte、Short、Long）对象做了缓存：
// - 这个范围内的数字装箱时，不会新建对象，而是复用缓存中的同一个对象；
// - 超出这个范围的数字，每次装箱都会新建对象。
//
// 下面代码之所以采用`Int?`，就是为了验证`装箱`。
// -------------------------------------------------------


fun main() {

    // 演示[-128, 127]使用内存优化。


    for (i: Int in -130..-126) {
        var num1: Int? = i
        var num2: Int? = i
        println("num1 = $num1, num2 = $num2, num1 == num2 is ${num1 == num2}")
        println("num1 = $num1, num2 = $num2, num1 === num2 is ${num1 === num2}")
    }

    println("-------------------------------------------")


    for (i: Int in 126..130) {
        var num1: Int = i
        var num2: Int = i
        println("num1 = $num1, num2 = $num2, num1 == num2 is ${num1 == num2}")
        println("num1 = $num1, num2 = $num2, num1 === num2 is ${num1 === num2}")
    }

}


