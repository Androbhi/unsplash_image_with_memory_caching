package com.assignment.prashntadvait.data.mapper

interface Mapper<in I, out O> {
    suspend fun map(input: I): O
}