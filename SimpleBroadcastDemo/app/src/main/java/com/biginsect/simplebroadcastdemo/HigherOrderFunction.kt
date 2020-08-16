package com.biginsect.simplebroadcastdemo

/**
 * 高阶函数，将函数作为参数传入另一个函数
 * @author biginsect
 * @date 2020/8/16
 */

fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}

fun main() {
    val num1 = 100
    val num2 = 80
    val result1 = num1AndNum2(num1, num2, ::plus)
    val r = num1AndNum2(num1, num2){ n1, n2 -> n1 + n2}
    val result2 = num1AndNum2(num1, num2, ::minus)
    println(result1)
    println(result2)
}