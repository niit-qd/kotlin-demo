// [Returns and jumps](https://kotlinlang.org/docs/returns.html)

package com.demo.kotlin.language_guide.control_flow

// -------------------------------------------------------
// Returns and jumps
// -------------------------------------------------------


// -------------------------------------------------------
// Break and continue labels
// -------------------------------------------------------

//fun main() {
//    myloop@ for (i in 1..10) {
//        for (j in 1..10) {
//            if (i == 5 && j == 6) {
//                println("$i $j break")
//                break@myloop
//            }
//            println("$i $j")
//        }
//    }
//}

// -------------------------------------------------------
// Return to labels
// -------------------------------------------------------

//// lambda 表达式标签
//fun foo() {
//    listOf(1, 2, 3, 4, 5).forEach lit222@{
//        if (it == 3) return@lit222
//        print(it)
//    }
//    print(" done with explicit label")
//}
//
//fun main() {
//    foo()
//}

//// 隐式标签
//fun foo() {
//    listOf(1, 2, 3, 4, 5).forEach {
//        if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
//        print(it)
//    }
//    print(" done with implicit label")
//}
//
//fun main() {
//    foo()
//}

//// 匿名方法
//fun foo() {
//    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
//        if (value == 3) return  // local return to the caller of the anonymous function - the forEach loop
//        print(value)
//    })
//    print(" done with anonymous function")
//}
//
//fun main() {
//    foo()
//}

//// 使用run关键词执行一个lambda表达式。这里为了体现跳转，对lambda表达式使用标签标记。
//// run的用法：[run](https://kotlinlang.org/docs/scope-functions.html#run)
//fun foo() {
//      run myLoop@{
//        listOf(1, 2, 3, 4, 5).forEach {
//            if (it == 3) return@myLoop // non-local return from the lambda passed to run
//            print(it)
//        }
//    }
//    print(" done with nested loop")
//}
//
//fun main() {
//    foo()
//}
