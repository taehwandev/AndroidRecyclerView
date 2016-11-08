package tech.thdev.androidrecyclerview.network

import android.util.Log
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
            .client(createOkHttpClient())
            .build().create(clazz)

private fun createOkHttpClient() =
        OkHttpClient.Builder().apply {
            readTimeout(2000, TimeUnit.MICROSECONDS)
            writeTimeout(2000, TimeUnit.MICROSECONDS)
            connectTimeout(2000, TimeUnit.MICROSECONDS)
            addInterceptor(initHttpLoggingInterceptor())
        }.build()

/**
 * Init logging level
 */
private fun initHttpLoggingInterceptor() =
        HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.v("OkHttp", "message : $it")
        }).apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }