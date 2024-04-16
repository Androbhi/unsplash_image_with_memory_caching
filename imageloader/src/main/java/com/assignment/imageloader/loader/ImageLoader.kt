package com.assignment.imageloader.loader

import android.graphics.Bitmap

interface ImageLoader {

    suspend fun loadNStoreImage(imageLink: String): Bitmap?

}