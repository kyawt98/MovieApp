package com.kyawt.shimmertesting.service.repository

import com.kyawt.shimmertesting.service.model.detail.MovieDetail
import com.kyawt.shimmertesting.service.model.movie.Movie

class MovieRepository {
    val service = ServiceProvider.getService()

    suspend fun getPopular(): Movie{
        return service.getPopular()
    }

    suspend fun getNowPlaying() : Movie{
        return service.getNowPlaying()
    }

    suspend fun getLatest() : Movie{
        return service.getLatest()
    }

    suspend fun getTopRated() : Movie{
        return service.getTopRated()
    }

    suspend fun getUpcoming() : Movie{
        return service.getUpcoming()
    }

    suspend fun getMovieDetail(movie_id : Int) : MovieDetail{
        return service.getDetail(movie_id)
    }
}