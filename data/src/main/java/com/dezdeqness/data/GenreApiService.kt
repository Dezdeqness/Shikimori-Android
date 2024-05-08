package com.dezdeqness.data

import com.dezdeqness.data.model.GenreRemote
import retrofit2.Call
import retrofit2.http.GET

interface GenreApiService {

    @GET("genres/")
    fun getListAnime(): Call<List<GenreRemote>>

}
