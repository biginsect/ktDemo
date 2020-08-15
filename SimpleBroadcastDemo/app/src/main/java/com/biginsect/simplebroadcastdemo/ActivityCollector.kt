package com.biginsect.simplebroadcastdemo

import android.app.Activity

/**
 *
 * @author biginsect
 * @date 2020/8/15
 */
object ActivityCollector {

    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (activity in activities) {
            activity.finish()
        }
        activities.clear()
    }
}