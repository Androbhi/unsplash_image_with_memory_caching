package com.assignment.prashntadvait.viewstate

sealed interface ViewStateValue<out T> {
    object Idle : ViewStateValue<Nothing>
    data class Success<T>(val value: T) : ViewStateValue<T>
    data class Failure(val throwable: Any?) : ViewStateValue<Nothing>
    data class Loading(val any: Any?): ViewStateValue<Nothing>

    operator fun invoke() = (this as? Success<T>)?.value
}

inline fun <T> ViewStateValue<T>.onSuccess(block: (T) -> Unit) = also {
    (it as? ViewStateValue.Success)?.value?.let(block)
}

inline fun <T> ViewStateValue<T>.onFailure(block: (Any?) -> Unit) = also {
    (it as? ViewStateValue.Failure)?.throwable?.let(block)
}

inline fun <T> ViewStateValue<T>.onLoading(block: (Any?) -> Unit) = also {
    (it as? ViewStateValue.Loading)?.any?.let(block)
}

inline fun <T> ViewStateValue<T>.fold(onSuccess: (T) -> Unit, onFailed: (Any?) -> Unit) =
    when (this) {
        is ViewStateValue.Success -> onSuccess(value)
        is ViewStateValue.Failure -> onFailed(throwable)
        is ViewStateValue.Loading -> onLoading { any }
        else -> Unit
    }

inline fun <T, R> ViewStateValue<T>.map(block: (T) -> R): ViewStateValue<R> = when (this) {
    is ViewStateValue.Success<T> -> ViewStateValue.Success(block(value))
    is ViewStateValue.Failure -> ViewStateValue.Failure(throwable)
    is ViewStateValue.Loading -> ViewStateValue.Loading(any)
    is ViewStateValue.Idle -> ViewStateValue.Idle
}