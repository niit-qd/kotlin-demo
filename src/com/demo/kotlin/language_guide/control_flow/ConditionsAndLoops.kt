// [Conditions and loops](https://kotlinlang.org/docs/control-flow.html)

package com.demo.kotlin.language_guide.control_flow

import kotlin.random.Random

// -------------------------------------------------------
// If expression
// -------------------------------------------------------

//fun main() {
//    val heightAlice: Int = 160
//    val heightBob: Int = 175
//
//    var taller = heightAlice
//    if (heightAlice < heightBob) taller = heightBob
//    println("taller = $taller")
//
//    // Uses an else branch
//    if (heightAlice > heightBob) {
//        taller = heightAlice
//    } else {
//        taller = heightBob
//    }
//    println("taller = $taller")
//
//    // Uses if as an expression
//    taller = if (heightAlice > heightBob) heightAlice else heightBob
//    println("taller = $taller")
//
//    // Uses else if as an expression:
//    val heightLimit = 150
//    val heightOrLimit = if(heightLimit > heightAlice) heightLimit else if (heightAlice > heightBob) heightAlice else heightBob
//    println("heightLimit = $heightLimit, heightOrLimit = $heightOrLimit")
//
//    println("Taller height is $taller")
//    // Taller height is 175
//    println("Height or limit is $heightOrLimit")
//    // Height or limit is 175
//}

// Each branch in an if expression can be a block, where the value of the last expression becomes the result:
//fun main() {
//    val heightAlice = 160
//    val heightBob = 175
//
//    val taller = if(heightAlice > heightBob) {
//        println("heightAlice:$heightAlice > heightBob:$heightBob")
//        heightAlice
//    }else{
//        println("heightAlice:$heightAlice < heightBob:$heightBob")
//        heightBob
//    }
//    println("Taller height is $taller")
//}

// -------------------------------------------------------
// When expressions and statements
// -------------------------------------------------------

//fun main() {
//    val userRole = "Editor"
//    when (userRole) {
//        "Viewer"->println("User has read-only access")
//        "Editor"->println("User can edit content")
//        else ->println("User role is not recognized")
//    }
//}

//fun main() {
//    val x = 2
//    val text = when (x) {
//        1 -> "x == 1"
//        2 -> "x == 2"
//        else -> "x is neither 1 nor 2"
//    }
//    println("x = $x, text = $text")
//}

//fun main() {
//    val x = 1
//    when (x){
//        1 -> print("x == 1")
//        2 -> print("x == 2")
//        else -> print("x is nither 1 nor 2")
//    }
//}

/* *************************** Statements *************************** */

//fun main() {
//    val deliverStatus = "OutForDelivery"
//    when (deliverStatus) {
//        // // Not all cases are covered
//        "Pending" -> println("Your order is being prepared")
//        "Shipped" -> println("Your order is on the way")
//    }
//}

/* *************************** Expressions *************************** */

//// If your when expression has a subject
//enum class Bit {
//    ZERO, ONE,
//}
//
//fun getRandomBit(): Bit {
//    return if (Random().nextBoolean()) Bit.ONE else Bit.ZERO
//}
//
//fun main() {
//    val numericValue = when (getRandomBit()) {
//        Bit.ZERO -> 0
//        Bit.ONE -> 1
//    }
//
//    println("Random bit as number: $numericValue")
//    // Random bit as number: 0
//}

//// If your when expression doesn't have a subject
//fun main() {
//    val localFileValue = 1200
//    val remoteFileValue = 1200
//
//    val message = when {
//        localFileValue > localFileValue -> "Local file is larger than remote file"
//        localFileValue < localFileValue -> "Local file is smaller than remote file"
//        else -> "Local and remote files are the same file"
//    }
//
//    println(message)
//    // Local and remote files are the same size
//}

/* *************************** Other ways to use when *************************** */

//// Group multiple conditions into a single branch using commas
//fun main() {
//    val ticketPriority = "High"
//    when (ticketPriority) {
//        "Low", "Medium" -> println("Standard response time")
//        else -> println("High-priority handing")
//    }
//}

//// Use expressions that evaluate to true or false as branch conditions:
//fun main() {
//    val storedPin = "1234"
//    val enteredPin = 1234
//
//    when (enteredPin) {
//        // Expression
//        storedPin.toInt() -> println("PIN is correct")
//        else -> println("Incorrect PIN")
//    }
//}

//// Check whether a value is or isn't contained in a range or collection using the in or !in keywords:
//fun main() {
//    val x = 7
//    val validNumber = setOf<Int>(15, 16, 17)
//
//    when (x) {
//        in 1..10 -> println("x is in the range")
//        in validNumber -> println("x is valid")
//        !in 10..20 -> println("x is outside the range")
//        else -> println("none of the above")
//    }
//}

//// Check a value's type using the is or !is keywords.
//fun hasPrefix(input: Any): Boolean = when (input) {
//    is String -> input.startsWith("ID-")
//    else -> false
//}
//
//fun main() {
//    val testInput = "ID-98345"
//    println(hasPrefix(testInput))
//    // true
//}

//// capture the subject in a variable
//fun main() {
//    val message = when (val input = "yes") {
//        "yes" -> "You said yes"
//        "no" -> "You said no"
//        else -> "Unrecognized input: $input"
//    }
//
//    println(message)
//    // You said yes
//}

//// Guard conditions 守护条件
//// Place a guard condition after the primary condition in the same branch, separated by if:
//sealed interface Animal {
//    data class Cat(val mouseHunter: Boolean) : Animal
//    data class Dog(val breed: String) : Animal
//}
//
//fun feedDog() = println("Feeding a dog")
//fun feedCat() = println("Feeding a cat")
//
//fun feedAnimal(animal: Animal) {
//    when (animal) {
//        // Branch with only primary condition
//        // Calls feedDog() when animal is Dog
//        is Animal.Dog -> feedDog()
//        // Branch with both primary and guard conditions
//        // Calls feedCat() when animal is Cat and not mouseHunter
//        is Animal.Cat if !animal.mouseHunter -> feedCat()
//        // Prints "Unknown animal" if none of the above conditions match
//        else -> println("Unknown animal")
//    }
//
//    //  when (animal) {
//    //     is Animal.Cat if (!animal.mouseHunter && animal.hungry) -> feedCat()
//    //     else -> {}
//    // }
//
//    // when (animal) {
//    //     // Checks if `animal` is `Dog`
//    //     is Animal.Dog -> feedDog()
//    //     // Guard condition that checks if `animal` is `Cat` and not `mouseHunter`
//    //     is Animal.Cat if !animal.mouseHunter -> feedCat()
//    //     // Calls giveLettuce() if none of the above conditions match and animal.eatsPlants is true
//    //     else if animal.eatsPlants -> giveLettuce()
//    //     // Prints "Unknown animal" if none of the above conditions match
//    //     else -> println("Unknown animal")
//    // }
//}
//
//fun main() {
//    val animals = listOf(
//        Animal.Dog("Beagle"),
//        Animal.Cat(mouseHunter = false),
//        Animal.Cat(mouseHunter = true),
//    )
//    animals.forEach { feedAnimal(it) }
//    // Feeding a dog
//    // Feeding a cat
//    // Unknown animal
//}

// -------------------------------------------------------
// For loops
// -------------------------------------------------------

//// The body of a for loop can be a block with curly braces {}.
//// curly braces: 大括号
//fun main() {
//    val shoppingList = listOf("Milk", "Bananas", "Bread")
//    println("Things to buy:")
//    for (item in shoppingList) {
//        println("- $item")
//    }
//    // Things to buy:
//    // - Milk
//    // - Bananas
//    // - Bread
//}

/* *************************** Ranges *************************** */

//// To iterate over a range of numbers, use a range expression with .. and ..< operators:
//
//fun main() {
//    println("Closed-ended range:")
//    for (i in 1..6) {
//        print(i)
//    }
//    // Closed-ended range:
//    // 123456
//
//    println("\nOpen-ended range:")
//    for (i in 1..<6) {
//        print(i)
//    }
//    // Open-ended range:
//    // 12345
//
//    println("\nReverse order in steps of 2:")
//    for (i in 6 downTo 0 step 2) {
//        print(i)
//    }
//    // Reverse order in steps of 2:
//    // 6420
//}

/* *************************** Arrays *************************** */

//// If you want to iterate through an array or a list with an index, you can use the indices property:
//
//fun main() {
//    val routinesSteps = arrayOf("Wake up", "Brush teeth", "Make coffee")
//    for (index in routinesSteps.indices) {
//        println(routinesSteps[index])
//    }
//    // Wake up
//    // Brush teeth
//    // Make coffee
//}

//// Alternatively, you can use the .withIndex() function from the standard library:
//
//fun main() {
//    val routineSteps = arrayOf("Wake up", "Brush teeth", "Make coffee")
//    for ((index, value) in routineSteps.withIndex()) {
//        println("The step $index is \"$value\"")
//    }
//    // The step at 0 is "Wake up"
//    // The step at 1 is "Brush teeth"
//    // The step at 2 is "Make coffee"
//}

/* *************************** Iterators﻿ *************************** */

//// You can create your own iterators by providing a member or extension function called iterator() that returns an Iterator<>.
//// The iterator() function must have a next() function and a hasNext() function that returns a Boolean.
//
//class Booklet(val totalPages: Int) : Iterable<Int> {
//    override fun iterator(): Iterator<Int> {
//        return object : Iterator<Int> {
//            var current = 1
//            override fun hasNext() = current <= totalPages
//            override fun next() = current++
//        }
//    }
//}
//
//fun main() {
//    val booklet = Booklet(3)
//    for (page in booklet) {
//        println("Reading page $page")
//    }
//    // Reading page 1
//    // Reading page 2
//    // Reading page 3
//}

//class Booklet(val totalPages: Int) {
//    // 本质是使用操作符iterator来实现代理器
//    operator fun iterator(): Iterator<Int> {
//
//        // 下面列出3种实现方式来阐明自定义迭代器的实现方式
//
//        // // 1）本质是提供一个迭代器实例
//        // // 注意：由于是override，所以其后可以省略operator关键字
//        // return object : Iterator<Int> {
//        //     var current = 1
//        //     override fun hasNext() = current <= totalPages
//        //     override fun next() = current++
//        // }
//
//        // // 2）可以先创建一个临时代理对象，用来实现具体的hasNext方法（用myHasNext方法来代理实现）和next方法（用myNext方法来代理实现）；
//        // // 然后再构建一个真正的迭代器实例，直接调用代理对象中的必要方法：hasNext方法（用myHasNext方法来代理实现）和next方法（用myNext方法来代理实现）
//        // // 只要最后一个方法返回Iterator的实例对象即可。在此之前，中间可以迭代任意多个临时实例。
//        // return object {
//        //     var current = 1
//        //
//        //     fun myHasNext() = current <= totalPages
//        //     fun myNext() = current++
//        // }.let {
//        //     object : Iterator<Int> {
//        //         override fun hasNext() = it.myHasNext()
//        //         override fun next() = it.myNext()
//        //     }
//
//        // // 3）参考Iterator接口的方法定义，创建一个带有hasNext方法和next的代理实例，然后基于该代理实例创建要返回的迭代器实例。
//        // // TODO: 这里有一个疑问，既然运算符约定列表中没有“hasNext”和"next"，但是这两个方法依然可以使用operator修饰。
//        // // TODO: 已知的一个线索是Iterator的接口定义中为这两个方法使用了operator，那为什么在该接口里面可以使用呢？此问题后续确认后再做解释。
//        //
//        // return object {
//        //     var current = 1
//        //
//        //     operator fun hasNext() = current <= totalPages
//        //     operator fun next() = current++
//        // }.let {
//        //     object : Iterator<Int> {
//        //         override operator fun hasNext() = it.hasNext()
//        //         override operator fun next() = it.next()
//        //     }
//        // }
//    }
//}
//
//fun main() {
//    val booklet = Booklet(3)
//    for (page in booklet) {
//        println("Reading page $page")
//    }
//    // Reading page 1
//    // Reading page 2
//    // Reading page 3
//}

//// 不一定必须实现Iterator接口
//// You can create your own iterators by providing a member or extension function called iterator() that returns an Iterator<>.
//// The iterator() function must have a next() function and a hasNext() function that returns a Boolean.
//// 你可以通过提供一个名为 `iterator()` 的成员函数或扩展函数来创建自己的迭代器，该函数返回一个 `Iterator<>` 对象。
//// `iterator()` 函数必须包含一个 `next()` 函数和一个 `hasNext()` 函数，其中 `hasNext()` 函数返回一个布尔值。
//
//interface MyFakeIterator<T> {
//
//    operator fun hasNext(): Boolean
//    operator fun next(): T
//}
//
//class MyFakeIteratorBox(val totalPages: Int) {
//    operator fun iterator() = object : MyFakeIterator<Int> {
//        var current = 1
//
//        override fun hasNext(): Boolean = current < totalPages
//        override fun next(): Int = current++
//    }
//}
//
//fun main() {
//    val fakeIteratorBox = MyFakeIteratorBox(3)
//    for (page in fakeIteratorBox) {
//        println("Reading page $page")
//    }
//}

// -------------------------------------------------------
// While loops
// -------------------------------------------------------

//fun main() {
//    var carsInGarage = 0
//    val maxCapacity = 3
//    while (carsInGarage < maxCapacity) {
//        println("Car entered. Cars now in garage: $carsInGarage")
//        carsInGarage++
//    }
//    // Car entered. Cars now in garage: 1
//    // Car entered. Cars now in garage: 2
//    // Car entered. Cars now in garage: 3
//
//    println("Garage is full!")
//    // Garage is full!
//}

//fun main() {
//    var roll: Int
//    do {
//        roll = Random.nextInt(1, 7)
//        println("Rolled a $roll")
//    } while (roll != 6)
//    // Rolled a 2
//    // Rolled a 6
//
//    println("Got a 6! Game over.")
//    // Got a 6! Game over.
//}

// -------------------------------------------------------
// While loops
// -------------------------------------------------------

// Kotlin supports traditional break and continue operators in loops. See [Returns and jumps](https://kotlinlang.org/docs/returns.html).
