package com.assignment.imageloader.loader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.LruCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject

class ImageLoaderImpl @Inject constructor(
    private val memoryCache: LruCache<String, Bitmap>
) : ImageLoader {


    override suspend fun loadNStoreImage(imageLink: String): Bitmap? {

        val bitmap: Bitmap? = getBitmapFromMemCache(imageLink) ?: run {
            loadBitmapNStore(imageLink)
        }

        return bitmap
    }

    private suspend fun loadBitmapNStore(imageLink: String): Bitmap? {
        return withContext(Dispatchers.IO) {
            var bitmap: Bitmap? = null
            var connection: HttpURLConnection? = null
            var inputStream: InputStream? = null
            try {
                val imageUrl = URL(imageLink)
                connection = imageUrl.openConnection() as HttpURLConnection
                connection.connect()
                inputStream = connection.inputStream
                bitmap = BitmapFactory.decodeStream(inputStream)
                memoryCache.put(imageLink, bitmap)
                bitmap
            } catch (e: Exception) {
                e.printStackTrace()
                null
            } finally {
                connection?.disconnect()
                inputStream?.close()
            }
        }

    }

    private suspend fun getBitmapFromMemCache(imageLink: String): Bitmap? {
       return withContext(Dispatchers.IO){
            memoryCache.get(imageLink)
        }
    }

}