package com.prueba.tecniva.data.service

import com.prueba.tecniva.data.entities.detail.DetailsResponse
import com.prueba.tecniva.data.entities.movies.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET(GET_MOVIES_PATH)
    suspend fun getMovies(
        @Query(LANGUAGE) language: String = LANGUAGE_US,
        @Query(PAGE) page: Int
    ): MoviesResponse

    @GET(GET_MOVIE_DETAIL_PATH)
    suspend fun getMovieDetail(
        @Path(PATH_MOVIE_ID) movieId: Int,
        @Query(LANGUAGE) language: String = LANGUAGE_US
    ): DetailsResponse

    companion object {
        private const val MOVIE = "movie"
        private const val VERSION = "3"
        private const val NOW_PLAYING = "now_playing"
        private const val PATH_MOVIE_ID = "movie_id"
        private const val LANGUAGE_US = "en-US"
        private const val LANGUAGE = "language"
        private const val PAGE = "page"
        private const val GET_MOVIES_PATH = "$VERSION/$MOVIE/$NOW_PLAYING"
        private const val GET_MOVIE_DETAIL_PATH = "$VERSION/$MOVIE/{$PATH_MOVIE_ID}"

    }
}