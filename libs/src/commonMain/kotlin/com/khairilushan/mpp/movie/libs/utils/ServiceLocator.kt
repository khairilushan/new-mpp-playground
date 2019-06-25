package com.khairilushan.mpp.movie.libs.utils

import com.khairilushan.mpp.movie.libs.data.MovieDataSource
import com.khairilushan.mpp.movie.libs.data.MovieRepositoryImpl
import com.khairilushan.mpp.movie.libs.data.network.MovieEndpoint
import com.khairilushan.mpp.movie.libs.data.network.NetworkProvider
import com.khairilushan.mpp.movie.libs.domain.repository.MovieRepository

internal object ServiceLocator {

    object Movie {
        val networkProvider by lazy { NetworkProvider<MovieEndpoint>(PlatformServiceLocator.httpClientEngine) }

        val networkDataSource: MovieDataSource
            get() = MovieDataSource.Network(networkProvider)

        val repository: MovieRepository
            get() = MovieRepositoryImpl(networkDataSource)
    }
}
