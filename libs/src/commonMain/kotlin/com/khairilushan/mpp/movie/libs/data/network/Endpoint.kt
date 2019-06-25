package com.khairilushan.mpp.movie.libs.data.network

import io.ktor.http.HttpMethod

internal interface Endpoint {

    val baseUrl: String

    val headers: Map<String, String>
        get() = mapOf()

    val path: String

    val parameters: Map<String, Any>
        get() = mapOf()

    val method: HttpMethod
}
