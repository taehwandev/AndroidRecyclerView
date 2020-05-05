package tech.thdev.base.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Content v4.fragment replace.
 */
fun AppCompatActivity.replaceContentFragment(@IdRes frameId: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(frameId, fragment).commitAllowingStateLoss()
}

/**
 * find fragment by IdRes.
 */
fun AppCompatActivity.getContentFragment(@IdRes frameId: Int) =
    supportFragmentManager.findFragmentById(frameId)


fun <E> Context.startServiceClass(cls: Class<E>?) {
    val intent = Intent(this, cls)
    startService(intent)
}

fun <E> Context.stopServiceClass(cls: Class<E>?) {
    val intent = Intent(this, cls)
    stopService(intent)
}

fun Context.registerReceiverAction(
    broadcastReceiver: BroadcastReceiver,
    actionList: List<String>? = null
) {
    val intentFilter = IntentFilter()
    actionList?.filterNotNull()?.forEach { intentFilter.addAction(it) }
    registerReceiver(broadcastReceiver, intentFilter)
}