package com.assignment.prashntadvait.pagintor

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}