package domain.interactor

import kotlinx.coroutines.coroutineScope

@Suppress("unused")
sealed class Result<out T : Any> {
    data class Success<T : Any>(val value: T) : Result<T>()
    data class Failure(val errorCode: Int, val message: String) : Result<Nothing>()
}

interface RequestParams {
    fun build(): Map<String, String> = mapOf()
}

abstract class Interactor<P : RequestParams, R : Any> {

    abstract suspend fun build(params: P?): R

    suspend fun execute(params: P? = null) = coroutineScope {
        try {
            val result = build(params)
            Result.Success(result)
        } catch (t: Throwable) {
            Result.Failure(t.hashCode(), t.message.orEmpty())
        }
    }
}
