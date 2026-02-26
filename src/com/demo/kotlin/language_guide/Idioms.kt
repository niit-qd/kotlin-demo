// [Idioms](https://kotlinlang.org/docs/idioms.html)
package com.demo.kotlin.language_guide

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import java.io.File
import java.math.BigDecimal
import java.util.Date

// -------------------------------------------------------
// Create DTOs (POJOs/POCOs)
// -------------------------------------------------------

data class Customer(val name: String, var email: String)

//fun main() {
//    val customer = Customer("John", "John@a.com")
//    println(customer.name)
//    customer.email = "john@a.c"
//    println(customer.email)
//
//    val customer2= Customer("Tom","tom@b.c")
//    println(customer2.equals(customer))
//    println(customer.toString())
//
//    val customer3=customer.copy(email="john@b.c.d")
//    println(customer3.toString())
//
//    // component1(), component2(), ..., for all properties (see Data classes)
//    // 即有几个属性，就有几个以序号结尾的component，序号从1开始。
//    println(customer.component1())
//    println(customer.component2())
//}

// -------------------------------------------------------
// Default values for function parameters
// -------------------------------------------------------

fun foo(a: Int = 1, b: Int = 2) {
    println("a = $a, b = $b")
}

//fun main() {
//    println(foo())
//    println(foo(2))
//    println(foo(3, 4))
//}

// -------------------------------------------------------
// Filter a list
// -------------------------------------------------------

//fun main() {
//    val list = listOf(1, -2, 3, -4, 5)
//    println("list is $list")
//    val positives1 = list.filter { x -> x > 0 }
//    println("positives 1 is $positives1")
//    val positives2 = list.filter { it > 0 }
//    println("positives 2 is $positives2")
//}

// -------------------------------------------------------
// Check the presence of an element in a collection
// -------------------------------------------------------

//fun main() {
//    val emailsList = listOf("email1", "email2", "email3")
//    if ("email1" in emailsList) {
//        println("email1 exists")
//    }
//    if ("email6" !in emailsList) {
//        println("email6 doesn't exists")
//    }
//}

// -------------------------------------------------------
// String interpolation
// 字符串内插
// -------------------------------------------------------

//fun main() {
//    val name = "ZhangSan"
//    println("name = $name")
//}

// -------------------------------------------------------
// Read standard input safely
// -------------------------------------------------------

//fun main() {
//    val age = readln().toIntOrNull()
//    println("age = $age")
//}

// -------------------------------------------------------
// Instance checks
// -------------------------------------------------------

fun checkInstance(x: Any) {
    when (x) {
        is Int -> println("x is Int")
        is String -> println("x is String")
        is Boolean -> println("x is Boolean")
        else -> println("none of the above")
    }
}

//fun main() {
//    checkInstance(1)
//    checkInstance("ZhangSan")
//    checkInstance(true)
//    checkInstance(8.4)
//    checkInstance(8.4f)
//}

// -------------------------------------------------------
// Read-only list
// -------------------------------------------------------

//fun main() {
//    val list = listOf(1, 2, 3)
//    println(list)
//}

// -------------------------------------------------------
// Read-only list
// -------------------------------------------------------

//fun main() {
//    val map = mapOf("a" to 1, "b" to 2, "c" to true, "d" to 8.9f)
//    println(map["b"])
//}

// -------------------------------------------------------
// Access a map entry
// -------------------------------------------------------

//fun main() {
//    val map = mutableMapOf<Any, Any>("a" to 1, "b" to 2, "c" to true, "d" to 8.9f)
//    println(map["b"])
//    map["c"] = 9.9
//    println(map["c"])
//}

// -------------------------------------------------------
// Traverse a map or a list of pairs
// -------------------------------------------------------

//fun main() {
//    val map = mapOf("a" to 1, "b" to 2, "c" to true, "d" to 8.9f)
//    for ((k, v) in map) {
//        println("$k to $v")
//    }
//}

// -------------------------------------------------------
// Iterate over a range
// -------------------------------------------------------

//fun main() {
//    for (i in 6..10) {
//        println("i = $i")
//    }
//    (6..10).forEach {
//        println("it = $it")
//    }
//    println(" ----------------------- ")
//
//    for (i in 86..<90) {
//        println("i = $i")
//    }
//    (86..<90).forEach {
//        println("i = $it")
//    }
//    println(" ----------------------- ")
//
//    for (i in 1..10 step 3) {
//        println("i = $i")
//    }
//    (1..10 step 3).forEach {
//        println("i = $it")
//    }
//    println(" ----------------------- ")
//
//    for (i in 10 downTo 2 step 3) {
//        println("i = $i")
//    }
//    (10 downTo 2 step 3).forEach {
//        println("i = $it")
//    }
//    println(" ----------------------- ")
//}

// -------------------------------------------------------
// Lazy property
// -------------------------------------------------------

//fun main() {
//    val p: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
//        println("the value is computed only on first access")
//        // return@lazy "ZhangSan"
//        "ZhangSan"
//    }
//    println("Hello World")
//    println(p)
//}

// -------------------------------------------------------
// Extension functions
// -------------------------------------------------------

fun String.toStringNew(): String {
    return "Hello_$this"
}

//fun main() {
//    val name = "ZhangSan"
//    println("name = $name, hashcode = ${name.hashCode()}")
//    println("name.toStringNew = ${name.toStringNew()}, hashcode = ${name.toStringNew().hashCode()}")
//}

// -------------------------------------------------------
// Create a singleton
// -------------------------------------------------------

/**
 * Kotlin 中的 object 关键字是实现饿汉式单例的 “语法糖”—— 它会让 Kotlin 编译器自动帮你创建一个唯一的实例，
 * 且保证线程安全，无需像 Java 那样手动写双重校验锁等单例代码。
 * <br/>
 * 简单说：object 声明的类，JVM 启动后（或类首次被加载时）会自动初始化唯一实例，
 * 全程由 Kotlin/Java 虚拟机保证线程安全，你直接用即可。
 */
object MySingleton {
    val name = "James"
}

//fun main() {
//    println(MySingleton.name)
//}

// -------------------------------------------------------
// Use inline value classes for type-safe values
// -------------------------------------------------------

//inline value classes（Kotlin 1.5+ 正式稳定）是 Kotlin 提供的一种轻量级类型封装机制：
//它为单个基础值（如 String/Int/Long）创建语义化的专属类型，编译期做严格的类型校验；
//运行期会被 “内联”（擦除类型），直接使用基础值，无额外内存开销、无装箱拆箱性能损耗；
//核心注解：JVM 平台需加 @JvmInline（Kotlin/Native/JS 无需），语法核心是 value class。
//简单说：它是 “编译期类型安全 + 运行期零开销” 的完美结合，解决了「基础类型语义混淆」和「普通包装类性能损耗」的双重问题。
//
//1. 编译期（类型校验）
//编译器将 value class 视为独立类型，严格校验参数、返回值的类型匹配；
//比如 OrderId 和 UserId 是不同类型，传错直接编译失败。
//2. 运行期（类型擦除）
//JVM 字节码中不存在 value class 对应的类，直接用基础值替代；
//内联值类的方法 / 属性，会被编译成接收基础值的静态方法。

// 简单地说，在编译时表现得像一个带有单个参数构造函数的类，但是在运行时使用的是目标参数的类型。

@JvmInline
value class EmployeeId(val id: String) {
}

@JvmInline
value class CustomerId(private val id: String) {
    // 如果入参是private，需要提供一个getter
    val value: String
        get() = id
}

fun printEmployeeId(employeeId: EmployeeId) {
    println("Employee Id: ${employeeId.id}")
}

fun printCustomerId(customerId: CustomerId) {
    println("Customer Id: ${customerId.value}")
}

//fun main() {
//    val employeeId = EmployeeId("James")
//    val customerId = CustomerId("Jack")
//    printEmployeeId(employeeId)
//    printCustomerId(customerId)
//}

// -------------------------------------------------------
// Instantiate an abstract class
// -------------------------------------------------------

abstract class MyAbstractClass {
    abstract fun doSomething()
    abstract fun sleep()
}

//fun main() {
//    val myObject: MyAbstractClass = object : MyAbstractClass() {
//        override fun doSomething() {
//            println("doSomething")
//        }
//
//        override fun sleep() {
//            println("sleep")
//        }
//
//    }
//    myObject.doSomething()
//    myObject.sleep()
//}

// -------------------------------------------------------
// If-not-null shorthand
// -------------------------------------------------------

//fun main() {
//    val files= File(".").listFiles()
//    println(files?.size)
//}

// -------------------------------------------------------
// If-not-null-else shorthand
// -------------------------------------------------------

fun getSomeSize(): Int {
    return -1
}

//fun main() {
//    var files = File(".").list()
//    println(files?.size ?: "empty")
//
//    // files = null
//    val filesSize = files?.size ?: run {
//        val someSize = getSomeSize()
//        someSize * 2
//    }
//    println(filesSize)
//}

// -------------------------------------------------------
// Execute an expression if null
// -------------------------------------------------------

//fun main() {
//    val values = mapOf("" to 3, "name" to "John", "email" to "John@a.com")
//    val detail = values["detail"] ?: throw IllegalStateException("detail")
//    println("detail: $detail")
//}

// -------------------------------------------------------
// Get first item of a possibly empty collection
// -------------------------------------------------------

//fun main() {
//    val emails = listOf<String>()
//    val mainEmail = emails.firstOrNull() ?: "---"
//    println("mainEmail: $mainEmail")
//}

// -------------------------------------------------------
// Execute if not null
// -------------------------------------------------------

//fun main() {
//    val value = null
//    value?.let { println("null") }
//}

// -------------------------------------------------------
// Map nullable value if not null
// -------------------------------------------------------

//fun main() {
//    val defaultValue = "---"
//    val value = "Jone" // null
//    val mapped = value?.let { "hi,$it" } ?: defaultValue
//    println("mapped: $mapped")
//}

// -------------------------------------------------------
// Return on when statement
// -------------------------------------------------------

fun transform(color: String?): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 3
        else -> throw IllegalArgumentException("Invalid color parameter value: $color.")
    }
}

//fun main() {
//    println(transform("Red"))
//    println(transform("Orange"))
//    println(transform(null))
//}

// -------------------------------------------------------
// try-catch expression
// -------------------------------------------------------

fun count() {
    val value: Int = (Math.random() * 1000).toInt() % 3
    println("value is $value")
    val result = 1 / value
}

fun test() {
    val result = try {
        count()
    } catch (e: ArithmeticException) {
        throw IllegalArgumentException(e)
    }
}

//fun main() {
//    for (i in 1..10) {
//        test()
//    }
//}

// -------------------------------------------------------
// if expression
// -------------------------------------------------------

fun testIf(x: Int): String {
    val y = if (x == 1) {
        "One"
    } else if (x == 2) {
        "Two"
    } else {
        "Other"
    }
    return y
}

//fun main() {
//    println(testIf(1))
//    println(testIf(4))
//}

// -------------------------------------------------------
// Builder-style usage of methods that return Unit
// -------------------------------------------------------

fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

//fun main() {
//    println("arrayOfMinusOnes is ${arrayOfMinusOnes(10).asList()}")
//}

// -------------------------------------------------------
// Single-expression functions
// -------------------------------------------------------

fun theAnswer() = (Math.random() * 1000).toInt()
fun theAnswer2(): Int {
    return (Math.random() * 1000).toInt()
}

fun transform2(color: String): Int = when (color) {
    "Red" -> 0
    "Green" -> 1
    "Blue" -> 2
    else -> throw IllegalArgumentException("Invalid color parameter value: $color.")
}

//fun main() {
//    for (i in 1..5) {
//        println("the answer is ${theAnswer()}")
//    }
//    for (color in listOf<String>("Red", "Green", "Blue", "Cyan")) {
//        println("the transform of $color is ${transform2(color)}")
//    }
//}

// -------------------------------------------------------
// Call multiple methods on an object instance (with)
// -------------------------------------------------------


class Turtle {
    fun penDown() {
        println("Pen Down")
        println("|------------->")
    }

    fun penUp() {
        println("<-------------|")
        println("Pen Up")
    }

    fun turn(degrees: Double) {
        println("Turn $degrees")
    }

    fun forward(pixels: Double) {
        println("Forward $pixels")
    }
}

//fun main() {
//    val myTurtle = Turtle()
//    with(myTurtle) {
//        penDown()
//        for (i in 1..10) {
//            forward(100.0)
//            turn(90.0)
//        }
//        penUp()
//    }
//}

// -------------------------------------------------------
// Configure properties of an object (apply)
// -------------------------------------------------------

class Rectangle2(width: Int, height: Int) {
    var length: Int = 0
    var breadth: Int = 0
    var color: Int = 0x0000
}

// This is useful for configuring properties that aren't present in the object constructor.
// 用于配置非构造方法的成员变量

//fun main() {
//    val myRectangle = Rectangle2(3, 2).apply {
//        length = 3
//        breadth = 5
//        color = 0x1234
//    }
//}

// -------------------------------------------------------
// Java 7's try-with-resources
// -------------------------------------------------------

//fun main() {
//    val stream =
//        Files.newInputStream(Paths.get("D:/code_envrionment/Demo/Kotlin/untitled/src/com/demo/kotlin/language_guide/basic_syntax/Overview.kt"))
//    stream.buffered(100).reader(Charsets.UTF_8).use { reader -> println(reader.readText()) }
//}

// -------------------------------------------------------
// Generic function that requires the generic type information
// [理解Kotlin中的reified关键字](https://juejin.cn/post/7225457156816355365)
// [告别“类型擦除”：深入解析 Kotlin 中的 Inline 与 Reified 黑魔法](https://juejin.cn/post/7597416716542640134)
// -------------------------------------------------------

// 这里写一个示例，证明内敛函数无法进行递归。
// interface FileTBuilder<T> {
//     fun newFileT(file: File): T
// }
//
// inline fun <reified T> recursionDemo(dir: File?, collection: MutableList<T>, fileTBuilder: FileTBuilder<T>) {
//     if (null == dir) {
//         return
//     }
//     if (dir.isFile) {
//         collection.add(fileTBuilder.newFileT(dir));
//     }
//     if (dir.isDirectory) {
//         dir.listFiles()?.forEach {
//             // Inline function 'fun <reified T> recursionDemo(dir: File?, collection: MutableList<T>, fileTBuilder: FileTBuilder<T>): Unit' cannot be recursive.
//             // 内敛函数无法递归，所以这里会报错。
//             recursionDemo(it, collection, fileTBuilder)
//         }
//     }
// }

inline fun <reified T> isTypeOf(obj: Any): Boolean {
    return obj is T;
}

inline fun <reified T : Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)

//fun main() {
//    val a = 12;
//    println("$a is type of Number: ${isTypeOf<Number>(a)}");
//    println("$a is type of String: ${isTypeOf<String>(a)}");
//
//    class InnerClass {
//        var id: Int = -1
//        var name: String? = null
//        var gender: String? = null
//        var birthDate: Date? = null
//        override fun toString(): String {
//            return "InnerClass(id=$id, name=$name, gender=$gender, birthDate=$birthDate)"
//        }
//    }
//
//    val json: JsonElement =
//        JsonParser.parseString("{\"id\": 123, \"name\": \"James\", \"gender\": \"Male\", \"birthDate\": \"20260215\"}")
//    val t = Gson().fromJson(json, InnerClass::class.java)
//    println("json is \n${GsonBuilder().setPrettyPrinting().create().toJson(json)},\n t is $t")
//}

// -------------------------------------------------------
// Swap two variables
// -------------------------------------------------------

//fun main() {
//    var a = 1
//    var b = 2
//    println("a=$a, b=$b")
//    a = b.also { b = a }
//    println("a=$a, b=$b")
//}

// -------------------------------------------------------
// Mark code as incomplete (TODO)
// -------------------------------------------------------

fun calcTaxes(): BigDecimal = TODO("Not implemented yet")

//fun main() {
//    calcTaxes()
//}
