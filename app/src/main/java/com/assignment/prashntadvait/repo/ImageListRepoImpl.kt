package com.assignment.prashntadvait.repo

import com.assignment.prashntadvait.data.apiservice.ImageListApiService
import com.assignment.prashntadvait.data.entity.ImageListEntity
import com.assignment.prashntadvait.data.mapper.ImageListMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


private const val TAG = "ImageListRepoImpl"

internal class ImageListRepoImpl @Inject constructor(
    private val apiService: ImageListApiService
) : ImageListRepo {
    override suspend fun getImageList(
        page: Int,
        pageLimit: Int
    ): Result<List<ImageListEntity>> {
        val response = apiService.getImageList(
            page = page,
            perPage = pageLimit
        )
        if (response.isSuccessful.not()) {
            return Result.failure(
                Throwable(
                    response.errorBody()?.string()
                )
            )
        }
        return withContext(Dispatchers.IO) {
            ImageListMapper.map(
                response.body().orEmpty()
            )
        }
    }
}