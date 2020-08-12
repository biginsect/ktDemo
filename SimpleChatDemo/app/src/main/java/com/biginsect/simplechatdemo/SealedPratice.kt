package com.biginsect.simplechatdemo

import java.lang.Exception

/**
 *
 * @author biginsect
 * @date 2020/8/12
 */

sealed class Result

class Success(val msg: String) : Result()

class Failed(val error: Exception) : Result()

fun getResultMsg(result: Result) = when (result) {
    is Success -> result.msg
    is Failed -> result.error.message
}