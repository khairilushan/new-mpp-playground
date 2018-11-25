package domain.model

sealed class SortType(private val descending: Boolean) {

    val urlQueryValue: String
        get() = when (this) {
            is Popularity -> "popularity.$sortOrderValue"
            is ReleaseDate -> "release_date.$sortOrderValue"
            is Revenue -> "revenue.$sortOrderValue"
            is Title -> "title.$sortOrderValue"
            is VoteAverage -> "vote_average.$sortOrderValue"
            is VoteCount -> "vote_count.$sortOrderValue"
        }

    private val sortOrderValue: String
        get() = when (descending) {
            true -> "desc"
            else -> "asc"
        }

    class Popularity(descending: Boolean = true) : SortType(descending)

    class ReleaseDate(descending: Boolean = true) : SortType(descending)

    class Revenue(descending: Boolean = true) : SortType(descending)

    class Title(descending: Boolean = true) : SortType(descending)

    class VoteAverage(descending: Boolean = true) : SortType(descending)

    class VoteCount(descending: Boolean = true) : SortType(descending)
}
