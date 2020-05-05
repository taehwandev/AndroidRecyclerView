package tech.thdev.androidrecyclerview

import android.app.Application
import android.content.Context

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class MyApplication : Application() {

    companion object {
        lateinit var appContext: Context
            private set
    }

    init {
        appContext = this
    }
}
