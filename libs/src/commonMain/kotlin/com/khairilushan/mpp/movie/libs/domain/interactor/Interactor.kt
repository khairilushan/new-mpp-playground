package com.khairilushan.mpp.movie.libs.domain.interactor

import com.khairilushan.mpp.movie.libs.utils.ApplicationDispatcher
import com.khairilushan.mpp.movie.libs.utils.MainDispatcher
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

@Suppress("unused")
sealed class Result<out T : Any> {
    data class Success<T : Any>(val value: T) : Result<T>()
    data class Failure(val errorCode: Int, val message: String) : Result<Nothing>()
}

abstract class Interactor<P, R : Any>(
    dispatcher: CoroutineDispatcher = ApplicationDispatcher
) {

    private val scope: CoroutineScope
    private val parentJob = SupervisorJob()

    init {
        val context: CoroutineContext = parentJob + dispatcher
        scope = CoroutineScope(context)
    }

    abstract suspend fun build(params: P?): R

    fun execute(params: P? = null, completion: ((Result<R>) -> Unit)? = null) {
        scope.launch {
            val result = try {
                val result = build(params)
                Result.Success(result)
            } catch (t: Throwable) {
                Result.Failure(t.hashCode(), t.message.orEmpty())
            }

            withContext(MainDispatcher) { completion?.invoke(result) }
        }
    }
}
