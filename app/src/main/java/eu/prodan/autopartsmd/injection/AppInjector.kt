package eu.prodan.autopartsmd.injection

import android.app.Activity
import android.app.Application
import android.os.Bundle
import dagger.android.AndroidInjection
import dagger.android.HasActivityInjector
import eu.prodan.autopartsmd.AutopartsApplication

/**
 * Created by User on 13.04.2018.
 */
class AppInjector {

    companion object {
        fun init(autopartsApplication: AutopartsApplication){
            DaggerAppComponent.builder()
                    .application(autopartsApplication)
                    .build()
                    .inject(autopartsApplication)
            autopartsApplication.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks{
                override fun onActivityPaused(activity: Activity?) {
                   //
                }

                override fun onActivityResumed(activity: Activity?) {
                //
                }

                override fun onActivityStarted(activity: Activity?) {

                }

                override fun onActivityDestroyed(activity: Activity?) {

                }

                override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
                }

                override fun onActivityStopped(activity: Activity?) {
                }

                override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                    handleActivity(activity)
                }
            })
        }

        fun handleActivity(activity: Activity?){
            if(activity is HasActivityInjector){
                AndroidInjection.inject(activity)
            }
        }

    }

}