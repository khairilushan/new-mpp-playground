package presentation.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import utils.MainDispatcher
import kotlin.coroutines.CoroutineContext

abstract class ScopedPresenter : CoroutineScope, BasePresenter {

    protected val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + MainDispatcher

    override fun onViewDestroyed() {
        job.cancel()
    }
}
