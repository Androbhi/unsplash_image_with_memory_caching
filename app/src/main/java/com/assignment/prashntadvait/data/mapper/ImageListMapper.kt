package com.assignment.prashntadvait.data.mapper

import com.assignment.prashntadvait.data.dto.ImageListDto
import com.assignment.prashntadvait.data.entity.ImageListEntity

internal object ImageListMapper: Mapper<List<ImageListDto>, Result<List<ImageListEntity>>> {
    override suspend fun map(input: List<ImageListDto>): Result<List<ImageListEntity>> {
        return runCatching {
            input.map {
                ImageListEntity(
                    it.urls?.small
                )
            }
        }
    }
}