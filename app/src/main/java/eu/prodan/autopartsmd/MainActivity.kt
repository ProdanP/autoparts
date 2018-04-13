package eu.prodan.autopartsmd

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import eu.prodan.autopartsmd.local.ColesoProduct
import eu.prodan.autopartsmd.service.IRetrofitMethods
import eu.prodan.autopartsmd.utils.logd
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by User on 13.04.2018.
 */
class MainActivity : Activity(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector : DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var retrofitMethods: IRetrofitMethods


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editText  = findViewById<EditText>(R.id.search_input)
        var button = findViewById<Button>(R.id.search_button)

        val key = "AIzaSyCQ0tJIQ4qn7CXfqMXH-51zdV0z4BvqUkI"
        val cx = "015107599764325797462:pxiqz7so2z8"

        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                retrofitMethods.getProduct(key, cx, editText.text.toString())
                        .enqueue(object : Callback<ColesoProduct>{
                            override fun onResponse(call: Call<ColesoProduct>?, response: Response<ColesoProduct>?) {
                                logd("onResponse: " + response.toString())
                            }

                            override fun onFailure(call: Call<ColesoProduct>?, t: Throwable?) {
                                logd("onFailure: " + t.toString())
                            }
                        } )


            }
        })




    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}