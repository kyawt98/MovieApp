package com.kyawt.shimmertesting.service.repository

import com.kyawt.shimmertesting.service.model.detail.MovieDetail
import com.kyawt.shimmertesting.service.model.movie.Movie
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.service.model.video.Result
import com.kyawt.shimmertesting.service.model.video.Video
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("movie/popular?api_key=23f01e396bdfd898d7f52a5f5749afbd")
    suspend fun getPopular() : Movie

    @GET("movie/now_playing?api_key=23f01e396bdfd898d7f52a5f5749afbd")
    suspend fun getNowPlaying() : Movie

    @GET("movie/latest?api_key=23f01e396bdfd898d7f52a5f5749afbd")
    suspend fun getLatest() : Movie

    @GET("movie/top_rated?api_key=23f01e396bdfd898d7f52a5f5749afbd")
    suspend fun getTopRated() : Movie

    @GET("movie/upcoming?api_key=23f01e396bdfd898d7f52a5f5749afbd")
    suspend fun getUpcoming() : Movie

    @GET("movie/{movie_id}?api_key=23f01e396bdfd898d7f52a5f5749afbd")
    suspend fun getDetail(
        @Path("movie_id") movie_id: Int
    ) : MovieDetail

    @GET("movie/{movie_id}/similar?api_key=23f01e396bdfd898d7f52a5f5749afbd")
    suspend fun getSimilar(
        @Path("movie_id") movie_id: Int
    ): Movie

    @GET("movie/{movie_id}/videos?api_key=23f01e396bdfd898d7f52a5f5749afbd")
    suspend fun getVideo(
        @Path("movie_id") movie_id: Int
    ) : Result
}