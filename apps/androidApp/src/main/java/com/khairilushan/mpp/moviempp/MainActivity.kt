package com.khairilushan.mpp.moviempp

import android.app.Activity
import android.os.Bundle
import presentation.presenter.movielist.MovieListContract
import presentation.presenter.movielist.MovieListPresenter

class MainActivity : Activity(), MovieListContract.View {

    private lateinit var presenter: MovieListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun showLoadingView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoadingView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorAlert(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
