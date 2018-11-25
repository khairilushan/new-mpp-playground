package presentation.presenter.movielist

interface MovieListContract {

    interface View {
        fun showLoadingView()

        fun hideLoadingView()

        fun showErrorAlert(message: String)
    }

    interface Presenter {
        fun getMovieIdAtIndex(index: Int): Int?
    }
}
