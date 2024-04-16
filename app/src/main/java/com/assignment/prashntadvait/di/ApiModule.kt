package com.assignment.prashntadvait.di

import com.assignment.prashntadvait.BuildConfig
import com.assignment.prashntadvait.data.apiservice.ImageListApiService
import com.assignment.prashntadvait.data.interceptors.HeaderInformationInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun providesApiService(
        headerInformationInterceptor: HeaderInformationInterceptor
    ): ImageListApiService {
        return with(Retrofit.Builder()) {
            client(
                OkHttpClient
                    .Builder().apply {
                        if (BuildConfig.DEBUG) {
                            addInterceptor(
                                HttpLoggingInterceptor().apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                })
                        }
                        addInterceptor(headerInformationInterceptor)
                    }.build()
            )
            addConverterFactory(GsonConverterFactory.create())
            baseUrl(BuildConfig.BASE_URL)
        }.build().create(ImageListApiService::class.java)
    }
}