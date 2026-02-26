// [Packages and imports](https://kotlinlang.org/docs/packages.html)
package com.demo.kotlin.language_guide.basic_syntax

import com.demo.kotlin.language_guide.basic_syntax.pkg1.Message as Pkg1Message
import com.demo.kotlin.language_guide.basic_syntax.pkg2.Message as Pkg2Message

fun main() {
    val m1 = Pkg1Message()
    val m2 = Pkg2Message()
}