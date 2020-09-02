package com.kyawt.shimmertesting.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawt.shimmertesting.service.model.movie.Movie
import com.kyawt.shimmertesting.service.repository.MovieRepository
import kotlinx.coroutines.launch

class TopRatedViewModel: ViewModel() {
    var topRatedResult = MutableLiveData<Movie>()
    var movieRepository = MovieRepository()

    fun loadData(){
        viewModelScope.launch {
            var result = movieRepository.getTopRated()
            topRatedResult.value = result
        }
    }
}