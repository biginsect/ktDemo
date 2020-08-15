package com.biginsect.simplebroadcastdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AlertDialog

/**
 *
 * @author biginsect
 * @date 2020/8/16
 */
class ForceOfflineReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        AlertDialog.Builder(context).apply {
            setTitle("Warning")
            setMessage("You are forced to be offline. Please try to login again.")
            setCancelable(false)
            setPositiveButton("OK") { _, _ ->
                ActivityCollector.finishAll()
                val i = Intent(context, LoginActivity::class.java)
                context.startActivity(i)
            }
            show()
        }
    }
}