package com.assignment.prashntadvait.data.apiservice

import com.assignment.prashntadvait.data.dto.ImageListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageListApiService {
    @GET("photos")
    suspend fun getImageList(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<List<ImageListDto>>
}