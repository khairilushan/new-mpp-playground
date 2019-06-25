package com.khairilushan.mpp.movie.libs.data.entity

import com.khairilushan.mpp.movie.libs.domain.model.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieEntity(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("vote_count") val voteCount: Int,
    @SerialName("vote_average") val voteAverage: Float,
    @SerialName("popularity") val popularity: Float,
    @SerialName("poster_path") val posterPath: String,
    @SerialName("language") val language: String,
    @SerialName("genre_ids") val genreIds: List<Int>,
    @SerialName("backdrop_path") val backdropPath: String,
    @SerialName("overview") val overview: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("genres") val genres: List<Genre>,
    @SerialName("homepage") val homepage: String,
    @SerialName("production_companies") val productCompanies: List<ProductionCompany>,
    @SerialName("production_countries") val productCountries: List<ProductionCountry>,
    @SerialName("status") val status: String,
    @SerialName("tagLine") val tagLine: String,
    @SerialName("budget") val budget: Int,
    @SerialName("revenue") val revenue: Int,
    @SerialName("spoken_languages") val spokenLanguages: List<Language>,
    @SerialName("runtime") val runtime: Int
) {

    fun toMovie(): Movie {
        return Movie(
            id = id,
            title = title,
            voteCount = voteCount,
            voteAverage = voteAverage,
            popularity = popularity,
            posterPath = posterPath,
            language = language,
            genreIds = genreIds,
            backdropPath = backdropPath,
            overview = overview,
            releaseDate = releaseDate,
            genres = genres.map { it.toGenre() },
            homepage = homepage,
            productCompanies = productCompanies.map { it.toProductionCompany() },
            productCountries = productCountries.map { it.toProductionCountry() },
            status = status,
            tagLine = tagLine,
            budget = budget,
            revenue = revenue,
            spokenLanguages = spokenLanguages.map { it.toLanguage() },
            runtime = runtime
        )
    }

    @Serializable
    data class Genre(
        @SerialName("id") val id: Int,
        @SerialName("name") val name: String
    ) {
        fun toGenre(): Movie.Genre {
            return Movie.Genre(id.or(0), name.orEmpty())
        }
    }

    @Serializable
    data class ProductionCompany(
        @SerialName("id") val id: Int,
        @SerialName("logo_path") val logoPath: String,
        @SerialName("name") val name: String,
        @SerialName("origin_country") val originCountry: String
    ) {
        fun toProductionCompany(): Movie.ProductionCompany {
            return Movie.ProductionCompany(id, logoPath, name, originCountry)
        }
    }

    @Serializable
    data class ProductionCountry(
        @SerialName("iso_3166_1") val iso31661: String,
        @SerialName("name") val name: String
    ) {
        fun toProductionCountry(): Movie.ProductionCountry {
            return Movie.ProductionCountry(iso31661, name)
        }
    }

    @Serializable
    data class Language(
        @SerialName("iso_639_1") val iso6391: String,
        @SerialName("name") val name: String
    ) {
        fun toLanguage(): Movie.Language {
            return Movie.Language(iso6391, name)
        }
    }
}
