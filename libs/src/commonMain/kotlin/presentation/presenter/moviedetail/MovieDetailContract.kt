package presentation.presenter.moviedetail

interface MovieDetailContract {

    interface View {

        fun showLoadingView()

        fun hideLoadingView()

        fun showErrorAlert(message: String)
    }

    interface Presenter {

    }
}
