package com.kyawt.shimmertesting.service.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceProvider {
    companion object{
        const val BASE_URL ="https://api.themoviedb.org/3/"

        fun getService() : MovieService{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(MovieService::class.java)
        }

    }
}