package tech.thdev.androidrecyclerview.network

import android.util.Log
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.thdev.androidrecyclerview.BuildConfig
import java.util.concurrent.TimeUnit

/**
 * Created by Tae-hwan on 08/11/2016.
 */

fun <T> createRetrofit(clazz: Class<T>, baseUrl: String) =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(createOkHttpClient())
        .build().create(clazz)

private fun createOkHttpClient() =
    OkHttpClient.Builder().apply {
        readTimeout(2000, TimeUnit.MILLISECONDS)
        writeTimeout(2000, TimeUnit.MILLISECONDS)
        connectTimeout(2000, TimeUnit.MILLISECONDS)
        addInterceptor(initHttpLoggingInterceptor())
    }.build()

/**
 * Init logging level
 */
private fun initHttpLoggingInterceptor() =
    HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.v("OkHttp", "message : $message")

        }
    }).apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }