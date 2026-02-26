// [Annotations])(https://kotlinlang.org/docs/annotations.html)
package com.demo.kotlin.language_guide.basic_syntax

// -------------------------------------------------------
// Usage
// -------------------------------------------------------

@Retention(AnnotationRetention.RUNTIME)
annotation class MyDefaultAnnotation

@Target(AnnotationTarget.CLASS)
annotation class MyClassAnnotation

annotation class MyMethodAnnotation

@MyDefaultAnnotation
@MyMethodAnnotation
class MyClass {

    @MyDefaultAnnotation
    @MyMethodAnnotation
    fun myMethod() {

    }
}

class MyClass2 @MyDefaultAnnotation constructor() {}

// -------------------------------------------------------
// Constructors
// -------------------------------------------------------

annotation class Special(val why: String)

annotation class ReplaceWith(val expression: String)
annotation class Deprecated(val message: String, val replaceWith: ReplaceWith = ReplaceWith(""))

@Deprecated(message = "test")
class MyClass3 {
    @Deprecated(message = "test", replaceWith = ReplaceWith("test"))
    fun test() {
    }
}

//fun main() {
//    val myClass = MyClass3()
//}


// -------------------------------------------------------
// Lambdas
// -------------------------------------------------------

annotation class Suspendable

val f = @Suspendable { Thread.sleep(2) }


// -------------------------------------------------------
// Annotation use-site targets
// -------------------------------------------------------
// 注解目标（Annotation Target）
// Kotlin 中声明一个属性（比如 val name: String），底层会生成多个 Java 元素：
// 参数（param）：构造函数中接收该值的参数
// 字段（field）：类中存储该值的成员变量（幕后字段）
// getter/setter：属性的访问器方法（getName()/setName()）
// @field、@get、@param 就是用来指定注解绑定到哪个元素上，默认情况下注解的目标会根据上下文推断，但显式指定能避免歧义。
// -------------------------------------------------------
// 其作用是在对应的目标上应用相关的注解。例如
// 1） set (property setter)： `@set: Ann`，是在某个目标的setter方法上添加Ann注解
// 2） property (annotations with this target are not visible to Java)：`@property:Ann`，实在目标上应用的Ann注解，在Java中无法使用反射方法获取。
// -------------------------------------------------------

annotation class Ann()

@Ann
class Example(
    // annotate only the Java field
    @field:Ann val foo: String,
    // annotate only the Java getter
    @get:Ann var bar: String,
    // annotate only the Java constructor parameter
    @param:Ann val quux: String,
    @property:Ann var gender: String? = null
) {
    // @Email var email: String? = null

    var address: String? = null
}

fun main() {
    val example = Example("hello", "world", "hello")
    example.bar = "HelloWorld222"
    println("example.foo = ${example.foo}")
    println("example.bar = ${example.bar}")
    println("example.quux = ${example.quux}")

    // example.email = null
    // example.email = "HelloWorld"
    // example.email = "HelloWorld@test.com"
}

// -------------------------------------------------------
// Lambdas
// -------------------------------------------------------

@Repeatable
annotation class Tag(val name: String)

//@JvmRepeatable(value = Tags::class)
annotation class Tag2(val name: String)

annotation class Tags(val value: Array<Tag2>)

@Tag("Hello")
@Tag("World")
class MyClass4 {}

@Tag2("hello")
class MyClass5 {}

@Tags([Tag2("hello"), Tag2("world")])
class MyClass6 {}
