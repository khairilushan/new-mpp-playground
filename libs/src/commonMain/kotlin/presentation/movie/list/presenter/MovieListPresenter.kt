package presentation.presenter.movielist

import domain.interactor.GetMovieList
import domain.interactor.Result
import domain.model.Movie
import domain.model.SortType
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import presentation.presenter.ScopedPresenter
import utils.ApplicationDispatcher

class MovieListPresenter(
    private val view: MovieListContract.View?,
    private val getMovieList: GetMovieList
) : ScopedPresenter(), MovieListContract.Presenter {

    private var movies: List<Movie> = listOf()

    override fun onViewCreated() {
        view?.showLoadingView()

        retrieveMovieList()
    }

    override fun getMovieIdAtIndex(index: Int): Int? {
        if (index >= movies.size) return null
        return movies[index].id
    }

    private fun retrieveMovieList() = launch {

        val params = GetMovieList.Params(2018, 1, SortType.Popularity())
        val result = async(ApplicationDispatcher) { getMovieList.execute(params) }.await()

        when (result) {
            is Result.Success -> onRetrieveMovieSuccess(result.value)
            is Result.Failure -> onRetrieveMovieFailed(result.message)
        }
    }

    private fun onRetrieveMovieSuccess(movies: List<Movie>) {
        view?.hideLoadingView()
    }

    private fun onRetrieveMovieFailed(errorMessage: String) {
        view?.showErrorAlert(errorMessage)
    }

}
