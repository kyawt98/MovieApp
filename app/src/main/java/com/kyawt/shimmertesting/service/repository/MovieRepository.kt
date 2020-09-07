package com.kyawt.shimmertesting.service.repository
import com.kyawt.shimmertesting.service.model.detail.MovieDetail
import com.kyawt.shimmertesting.service.model.movie.Movie
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.service.model.video.Result

class MovieRepository {
    val service = ServiceProvider.getService()

    val YOUTUBE_VIDEO_PATH ="https://www.youtube.com/watch?v="

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

    suspend fun getVideo(movie_id: Int) : Result{
        return service.getVideo(movie_id)
    }

    fun loadVideo(videoPath:String): String {
        return YOUTUBE_VIDEO_PATH+videoPath
    }

    suspend fun getSimilarMovie(movie_id: Int) : Movie{
        return service.getSimilar(movie_id)
    }
}