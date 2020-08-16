package com.biginsect.simplebroadcastdemo

import java.lang.StringBuilder

/**
 * StringBuilder的扩展函数
 * @author biginsect
 * @date 2020/8/16
 */
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}