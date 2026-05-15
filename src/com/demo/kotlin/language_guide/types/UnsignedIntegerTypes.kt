package com.demo.kotlin.language_guide.types

import sun.awt.image.ImageRepresentation
import kotlin.reflect.typeOf

// [Unsigned integer types](https://kotlinlang.org/docs/unsigned-integer-types.html)

// -------------------------------------------------------
// Unsigned integer types
// -------------------------------------------------------

//fun main() {
//    println("UByte.MIN_VALUE = ${UByte.MIN_VALUE}, UByte.MAX_VALUE = ${UByte.MAX_VALUE}")
//    println("UShort.MIN_VALUE = ${UShort.MIN_VALUE}, UShort.MAX_VALUE = ${UShort.MAX_VALUE}")
//    println("UInt.MIN_VALUE = ${UInt.MIN_VALUE}, UInt.MAX_VALUE = ${UInt.MAX_VALUE}")
//    println("ULong.MIN_VALUE = ${ULong.MIN_VALUE}, ULong.MAX_VALUE = ${ULong.MAX_VALUE}")
//}

// -------------------------------------------------------
// Unsigned arrays and ranges
// -------------------------------------------------------

//@OptIn(ExperimentalUnsignedTypes::class)
//fun main() {
//    val uByteArray: UByteArray = ubyteArrayOf(0u, 1u, 2u, 3u, 4u, 5u)
//    uByteArray[2] = 12u
//    uByteArray.set(3, 13u)
//    for ((index, element) in uByteArray.withIndex()) {
//        println("$index: $element")
//    }
//
//    println("========== ========== ========== ==========")
//
//
//    val uShortArray: UShortArray = ushortArrayOf(0u, 1u, 2u, 3u, 4u, 5u)
//    uShortArray[2] = 12u
//    uShortArray.set(3, 13u)
//    for ((index, element) in uShortArray.withIndex()) {
//        println("$index: $element")
//    }
//
//    println("========== ========== ========== ==========")
//
//
//    val uIntArray: UIntArray = uintArrayOf(0u, 1u, 2u, 3u, 4u, 5u)
//    uIntArray[2] = 12u
//    uIntArray.set(3, 13u)
//    for ((index, element) in uIntArray.withIndex()) {
//        println("$index: $element")
//    }
//
//    println("========== ========== ========== ==========")
//
//
//    val uLongArray: ULongArray = ulongArrayOf(0u, 1u, 2u, 3u, 4u, 5u)
//    uLongArray[2] = 12u
//    uLongArray.set(3, 13u)
//    for ((index, element) in uLongArray.withIndex()) {
//        println("$index: $element")
//    }
//}

//fun main() {
//    println("===== ===== ===== =====")
//
//    val uIntRange = UIntRange(5u, 10u)
//    for (i in uIntRange) {
//        println(i)
//    }
//    println("----- ----- ----- -----")
//    val uIntProgression = UIntProgression.fromClosedRange(5u, 10u, 2)
//    for (i in uIntProgression) {
//        println(i)
//    }
//
//    println("===== ===== ===== =====")
//
//    val uLongRange = ULongRange(5u, 10u)
//    for (i in uLongRange) {
//        println(i)
//    }
//    println("----- ----- ----- -----")
//    val uLongProgression = ULongProgression.fromClosedRange(5u, 10u, 2)
//    for (i in uLongProgression) {
//        println(i)
//    }
//
//    println("===== ===== ===== =====")
//}

// -------------------------------------------------------
// Unsigned integers literals
// -------------------------------------------------------

//fun main() {
//    val b: UByte = 1u  // UByte, expected type provided
//    val s: UShort = 1u // UShort, expected type provided
//    val l: ULong = 1u  // ULong, expected type provided
//
//    val a1 = 42u // UInt: no expected type provided, constant fits in UInt
//    val a2 = 0xFFFF_FFFF_FFFFu // ULong: no expected type provided, constant doesn't fit in UInt
//
//    println("b is ${b.javaClass}, value is $b")
//    println("s is ${s.javaClass}, value is $s")
//    println("l is ${l.javaClass}, value is $l")
//    println("a1 is ${a1.javaClass}, value is $a1")
//    println("a2 is ${a2.javaClass}, value is $a2")
//
//    println("===== ===== ===== =====")
//
//    val a = 1UL // ULong, even though no expected type provided and the constant fits into UInt
//
//    println("a is ${a.javaClass}, value is $a")
//}

// -------------------------------------------------------
// Use cases
// -------------------------------------------------------

//data class Color(var representation: UInt)
//
//@OptIn(ExperimentalUnsignedTypes::class)
//fun main() {
//    val yello = Color(0xFFCC00CCu)
//    val byteOrderMarkUtf8 = ubyteArrayOf(0xEFu, 0xBBu, 0xBFu)
//    println("yello = $yello")
//    println("byteOrderMarkUtf8:${byteOrderMarkUtf8.contentToString()}")
//}
