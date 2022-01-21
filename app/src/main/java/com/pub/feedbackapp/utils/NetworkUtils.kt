package com.pub.feedbackapp.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout


sealed class Result<out T>
class Success<out T>(val data: T) : Result<T>()
class Error(val exception: Throwable, val message: String = exception.localizedMessage ?: "localizedMessage is null") : Result<Nothing>()

inline fun <T> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Success) action(data)
    return this
}
inline fun <T> Result<T>.onError(action: (Error) -> Unit): Result<T> {
    if (this is Error) action(this)
    return this
}

suspend fun <T> safeCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): Result<T> {
    return withContext(dispatcher) {
        try {
            withTimeout(Constants.NETWORK_TIMEOUT) {
                Success(apiCall.invoke())
            }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            Error(throwable)
        }
    }
}