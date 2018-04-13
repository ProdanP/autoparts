package eu.prodan.autopartsmd.injection.modules

import dagger.Module
import dagger.Provides
import eu.prodan.autopartsmd.service.IRetrofitMethods
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.internal.Util
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by User on 12.04.2018.
 */
@Module
class RemoteModule {
    @Provides
    @Singleton
    fun providehttpDispatcher() : Dispatcher = Dispatcher(ThreadPoolExecutor(1, 16, 60, TimeUnit.SECONDS,
            SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false)))

    @Provides
    @Singleton
    fun provideHttpInterceptor() : Interceptor =
            Interceptor {
                chain -> chain.proceed(chain.request().newBuilder().build())
            }
    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: Interceptor, dispatcher: Dispatcher) : OkHttpClient =
            OkHttpClient.Builder()
                    .dispatcher(dispatcher)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .retryOnConnectionFailure(true)
                    .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : IRetrofitMethods =
            Retrofit.Builder()
                    .baseUrl("https://www.googleapis.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()
                    .create(IRetrofitMethods::class.java)

}