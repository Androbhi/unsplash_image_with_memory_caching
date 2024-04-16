package com.assignment.prashntadvait.data.di

import com.assignment.prashntadvait.data.interceptors.HeaderInformationInterceptor
import com.assignment.prashntadvait.data.interceptors.HeaderInformationInterceptorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    internal abstract fun bindsHeaderInformationInterceptor(
        headerInformationInterceptorImpl: HeaderInformationInterceptorImpl
    ): HeaderInformationInterceptor
}