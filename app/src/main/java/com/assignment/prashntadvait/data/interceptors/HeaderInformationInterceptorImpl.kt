package com.assignment.prashntadvait.data.interceptors

import com.assignment.prashntadvait.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

private const val KEY_ACCEPT_VERSION = "Accept-Version"
private const val KEY_AUTHORIZATION = "Authorization"

internal class HeaderInformationInterceptorImpl @Inject constructor() :
    HeaderInformationInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // Adding the header items only if it unsplash API
        val isUnSplashAPi = chain.request().url.toString().startsWith(BuildConfig.BASE_URL, true)

        return if (isUnSplashAPi) {
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader(KEY_ACCEPT_VERSION, "V1")
            requestBuilder.addHeader(KEY_AUTHORIZATION, "Client-ID ${BuildConfig.ACCESS_KEY}")
            chain.proceed(request = requestBuilder.build())
        } else {
            chain.proceed(chain.request())
        }
    }

}