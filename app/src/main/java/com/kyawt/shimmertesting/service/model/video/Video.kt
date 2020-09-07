package com.kyawt.shimmertesting.service.model.video


import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<Result>
)