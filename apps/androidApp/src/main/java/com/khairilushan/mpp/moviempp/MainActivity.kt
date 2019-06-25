package com.khairilushan.mpp.moviempp

import android.app.Activity
import android.os.Bundle
import com.khairilushan.mpp.movie.libs.domain.interactor.GetMovieList
import com.khairilushan.mpp.movie.libs.domain.interactor.Result
import com.khairilushan.mpp.movie.libs.domain.model.SortType

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val params = GetMovieList.Params(year = 2019, page = 1, sortType = SortType.Popularity())
        val getMovieList = GetMovieList.create()

        getMovieList.execute(params) {
            when (it) {
                is Result.Success -> print(it.value)
                is Result.Failure -> print(it.message)
            }
        }
    }
}
