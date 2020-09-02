package com.kyawt.shimmertesting.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawt.shimmertesting.service.model.movie.Movie
import com.kyawt.shimmertesting.service.repository.MovieRepository
import com.kyawt.shimmertesting.view.exts.logd
import kotlinx.coroutines.launch

class PopularViewModel: ViewModel() {
    var popularResult = MutableLiveData<Movie>()
    var movieRepository = MovieRepository()

    fun loadData(){
        viewModelScope.launch {
            val result = movieRepository.getPopular()
            popularResult.value = result

            logd("Poster", result.toString())
        }
    }
}