package presentation.presenter.moviedetail

import domain.interactor.GetMovieDetail
import domain.interactor.Result
import domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import presentation.presenter.ScopedPresenter

class MovieDetailPresenter(
    private val view: MovieDetailContract.View?,
    private val getMovieDetail: GetMovieDetail
) : ScopedPresenter(), MovieDetailContract.Presenter {

    private var movie: Movie? = null

    override fun onViewCreated() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun retrieveMovieDetail(id: Int) = launch {
        val params = GetMovieDetail.Params(id)
        val result = async(Dispatchers.Default) { getMovieDetail.execute(params) }.await()

        when (result) {
            is Result.Success -> onRetrieveMovieDetailSuccess(result.value)
            is Result.Failure -> onRetrieveMovieDetailFailed(result.message)
        }
    }

    private fun onRetrieveMovieDetailSuccess(movie: Movie) {
        this.movie = movie
        view?.hideLoadingView()
    }

    private fun onRetrieveMovieDetailFailed(errorMessage: String) {
        view?.showErrorAlert(errorMessage)
    }
}
