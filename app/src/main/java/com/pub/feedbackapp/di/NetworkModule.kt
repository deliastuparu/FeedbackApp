package com.pub.feedbackapp.di


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Use to provide general network utils.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpBuilder(logger: HttpLoggingInterceptor): OkHttpClient.Builder {
        return OkHttpClient
            .Builder()
            .addInterceptor(logger)
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(okHttpBuilder: OkHttpClient.Builder, gsonBuilder: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    }
}