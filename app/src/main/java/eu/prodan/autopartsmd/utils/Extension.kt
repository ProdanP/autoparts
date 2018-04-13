package eu.prodan.autopartsmd.utils

import android.app.Activity
import android.util.Log
import eu.prodan.autopartsmd.BuildConfig

/**
 * Created by User on 13.04.2018.
 */
fun Activity.logd(message: String){
    if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName, message)
}