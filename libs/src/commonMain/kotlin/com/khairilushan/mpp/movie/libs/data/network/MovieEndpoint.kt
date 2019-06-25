package com.khairilushan.mpp.movie.libs.data.network

import io.ktor.http.HttpMethod

internal sealed class MovieEndpoint : Endpoint {

    override val baseUrl: String
        get() = "api.themoviedb.org"

    override val parameters: Map<String, Any>
        get() = mapOf("api_key" to "14bc774791d9d20b3a138bb6e26e2579")

    class MovieList(private val year: Int, private val page: Int, private val sort: String) : MovieEndpoint() {
        override val path: String
            get() = "/3/discover/movie"

        override val parameters: Map<String, Any>
            get() = super.parameters + mapOf("year" to year, "page" to page, "sort" to sort)

        override val method: HttpMethod
            get() = HttpMethod.Get
    }

    class MovieDetail(private val id: Int) : MovieEndpoint() {
        override val path: String
            get() = "/3/movie/$id"

        override val method: HttpMethod
            get() = HttpMethod.Get
    }
}
