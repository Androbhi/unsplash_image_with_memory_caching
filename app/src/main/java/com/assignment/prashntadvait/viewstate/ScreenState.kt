package com.assignment.prashntadvait.viewstate

import android.graphics.Bitmap

data class ScreenState(
    val isLoading: Boolean = false,
    val items: List<Bitmap?> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)