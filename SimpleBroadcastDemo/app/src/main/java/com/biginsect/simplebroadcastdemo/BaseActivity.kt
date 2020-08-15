package com.biginsect.simplebroadcastdemo

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * @author biginsect
 * @date 2020/8/15
 */
abstract class BaseActivity : AppCompatActivity() {

    private lateinit var mForceOfflineReceiver: ForceOfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getLayoutId() > 0) {
            setContentView(getLayoutId())
        }
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.biginsect.simplebroadcastdemo.FORCE_OFFLINE")
        mForceOfflineReceiver = ForceOfflineReceiver()
        registerReceiver(mForceOfflineReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(mForceOfflineReceiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    protected abstract fun getLayoutId(): Int
}