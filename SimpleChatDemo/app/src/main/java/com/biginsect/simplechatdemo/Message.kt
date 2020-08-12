package com.biginsect.simplechatdemo

/**
 *
 * @author biginsect
 * @date 2020/8/12
 */
class Message(val content: String, val tyep: Int) {
    companion object {
        const val TYPE_RECEIVED = 0
        const val TYPE_SEND = 1
    }
}