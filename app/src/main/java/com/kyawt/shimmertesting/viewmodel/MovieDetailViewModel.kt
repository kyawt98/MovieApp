package com.kyawt.shimmertesting.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawt.shimmertesting.service.model.detail.MovieDetail
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.service.model.video.Result
import com.kyawt.shimmertesting.service.model.video.Video
import com.kyawt.shimmertesting.service.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieDetailViewModel : ViewModel(){
    var movieId = MutableLiveData<MovieResult>()

    fun setID(movie_id: MovieResult){
        movieId.value = movie_id
    }
    var movieDetailResult = MutableLiveData<MovieDetail>()
    fun detailResult() : LiveData<MovieDetail> = movieDetailResult
    var movieRepository = MovieRepository()

     fun loadData(movie_id: Int){
        viewModelScope.launch {
            var result = movieRepository.getMovieDetail(movie_id)
            movieDetailResult.value = result

        }
    }

    var loadVideo = MutableLiveData<Result>()
//    fun loadVideo(movie_id: Int){
//        viewModelScope.launch {
//            var result = movieRepository.getVideo(movie_id)
//            loadVideo.value = result
//        }
//    }
}