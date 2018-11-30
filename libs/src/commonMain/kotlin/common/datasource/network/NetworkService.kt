package common.datasource.network

import io.ktor.client.HttpClient
import io.ktor.client.request.request
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

abstract class NetworkService<T> {

    private val client: HttpClient by lazy { HttpClient() }

    internal open val baseUrl = "api.github.com"

    internal open val requestBody: Any = EmptyContent

    internal open val headers: Map<String, List<String>> = mapOf()

    internal abstract val path: String

    internal abstract fun parse(json: String): T

    internal open val httpMethod = HttpMethod.Get

    internal suspend fun execute(params: Map<String, Any>) = coroutineScope {
        async {
            val response: String = client.request {
                method = httpMethod
                body = requestBody
                url.apply {
                    protocol = URLProtocol.HTTPS
                    port = 443
                    host = baseUrl
                    encodedPath = "$path?${getUrlQueryFrom(params)}"
                }
            }
            return@async parse(response)
        }
    }

    private fun getUrlQueryFrom(params: Map<String, Any>) =
        params.map { "${it.key}=${it.value}" }.joinToString("&")
}
