package com.kyawt.shimmertesting.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawt.shimmertesting.service.model.movie.Movie
import com.kyawt.shimmertesting.service.repository.MovieRepository
import kotlinx.coroutines.launch

class LatestViewModel : ViewModel() {

    var latestResult = MutableLiveData<Movie>()
    var movieRepository = MovieRepository()

    fun loadData(){
        viewModelScope.launch {
            try {
                var result = movieRepository.getLatest()
                latestResult.value = result
            }catch (e:Exception){
                Log.d("Latest", e.toString())
            }
        }
    }
}