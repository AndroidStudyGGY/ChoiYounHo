package com.soten.test.di

import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.soten.test.data.network.api.GithubApi
import com.soten.test.data.network.interceptor.ApiInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val networkJson: Json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.github.com/repos/")
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .client(
                provideOkHttpClient(
                    ApiInterceptor(),
                    HttpLoggingInterceptor { log ->
                        Log.d("LOG_TAG", log)
                    }.apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideGithubApi(): GithubApi {
        return provideRetrofit().create(GithubApi::class.java)
    }

    private fun provideOkHttpClient(vararg interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().run {
            interceptor.forEach { addInterceptor(it) }
            build()
        }
    }
}