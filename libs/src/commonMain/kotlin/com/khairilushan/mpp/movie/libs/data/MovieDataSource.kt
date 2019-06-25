package com.khairilushan.mpp.movie.libs.data

import com.khairilushan.mpp.movie.libs.data.entity.MovieEntity
import com.khairilushan.mpp.movie.libs.data.entity.MovieListEntity
import com.khairilushan.mpp.movie.libs.data.network.MovieEndpoint
import com.khairilushan.mpp.movie.libs.data.network.NetworkProvider
import com.khairilushan.mpp.movie.libs.domain.model.Movie
import com.khairilushan.mpp.movie.libs.domain.repository.MovieRepository

internal interface MovieDataSource : MovieRepository {

    class Network(private val provider: NetworkProvider<MovieEndpoint>) : MovieDataSource {

        override suspend fun getMovieList(year: Int, page: Int, sort: String): List<Movie> {
            val endpoint = MovieEndpoint.MovieList(year, page, sort)
            val response = provider.request(endpoint, MovieListEntity.serializer())
            return response.results.map { it.toMovie() }
        }

        override suspend fun getMovieDetail(id: Int): Movie {
            val response = provider.request(MovieEndpoint.MovieDetail(id), MovieEntity.serializer())
            return response.toMovie()
        }

    }
}
