package com.assignment.imageloader.di

import android.graphics.Bitmap
import android.util.LruCache
import com.assignment.imageloader.loader.ImageLoader
import com.assignment.imageloader.loader.ImageLoaderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ImageLoaderModule {

    @Binds
    @Singleton
    abstract fun bindsImageLoader(
        imageLoader: ImageLoaderImpl
    ): ImageLoader

    companion object {
        @Provides
        @Singleton
        fun providesLruCache(): LruCache<String, Bitmap> {
            val memoryCache: LruCache<String, Bitmap>
            val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
            val cacheSize = maxMemory / 8
            memoryCache = object : LruCache<String, Bitmap>(cacheSize) {
                override fun sizeOf(key: String, bitmap: Bitmap): Int {
                    return bitmap.byteCount / 1024
                }
            }
            return memoryCache
        }

    }
}