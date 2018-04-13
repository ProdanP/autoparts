package eu.prodan.autopartsmd.service

import eu.prodan.autopartsmd.local.ColesoProduct
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by User on 13.04.2018.
 */
interface IRetrofitMethods {
    @GET("customsearch/v1")
    abstract fun getProduct(@Query("key") key: String, @Query("cx") cx: String, @Query("q") query: String): Call<ColesoProduct>
}