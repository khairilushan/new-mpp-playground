package domain.model

data class Movie(
    val id: Int?,
    val title: String?,
    val voteCount: Int?,
    val voteAverage: Float?,
    val popularity: Float?,
    val posterPath: String?,
    val language: String?,
    val genreIds: List<Int>?,
    val backdropPath: String?,
    val overview: String?,
    val releaseDate: String?,
    val genres: List<Genre>?,
    val homepage: String?,
    val productCompanies: List<ProductionCompany>?,
    val productCountries: List<ProductionCountry>?,
    val status: String?,
    val tagLine: String?,
    val budget: Int?,
    val revenue: Int?,
    val spokenLanguages: List<Language>?,
    val runtime: Int?
) {

    data class Genre(
        val id: Int?,
        val name: String?
    )

    data class ProductionCompany(
        val id: Int?,
        val logoPath: String?,
        val name: String?,
        val originCountry: String?
    )

    data class ProductionCountry(
        val iso31661: String?,
        val name: String?
    )

    data class Language(
        val iso6391: String?,
        val name: String?
    )
}
