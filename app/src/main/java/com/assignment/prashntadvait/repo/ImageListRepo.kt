package com.assignment.prashntadvait.repo

import com.assignment.prashntadvait.data.entity.ImageListEntity

interface ImageListRepo {
    suspend fun getImageList(
        page: Int,
        pageLimit: Int
    ): Result<List<ImageListEntity>>
}