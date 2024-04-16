package com.assignment.prashntadvait.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.imageloader.loader.ImageLoader
import com.assignment.prashntadvait.pagintor.DefaultPaginator
import com.assignment.prashntadvait.repo.ImageListRepo
import com.assignment.prashntadvait.viewstate.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import java.lang.Exception
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val repo: ImageListRepo,
    private val imageLoader: ImageLoader
) : ViewModel() {

    var state by mutableStateOf(ScreenState())

    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = { nextPage ->

            repo.getImageList(nextPage, 20)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { items, newKey ->
            supervisorScope {
                val images = items.map { imageEntity ->
                    async {
                        imageLoader.loadNStoreImage(imageEntity.imageUrl.orEmpty())
                    }
                }.awaitAll()

                state = state.copy(
                    items = state.items + images,
                    page = newKey,
                    endReached = items.isEmpty()
                )
            }
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            try {
                paginator.loadNextItems()
            } catch (e: Exception) {
                state = state.copy(
                    error = when (e) {
                        is UnknownHostException -> {
                            "No Internet"
                        }

                        else -> {
                            "Some thing went wrong"
                        }
                    }
                )
            }

        }
    }
}

