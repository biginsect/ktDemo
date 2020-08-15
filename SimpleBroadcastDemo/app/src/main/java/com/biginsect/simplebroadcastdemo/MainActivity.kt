package com.biginsect.simplebroadcastdemo

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 * @author biginsect
 * @date 2020/8/15
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        forceOffline.setOnClickListener {
            val intent = Intent("com.biginsect.simplebroadcastdemo.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}