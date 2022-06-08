package com.egor.memes.data.service

import com.egor.memes.data.entity.ResponseEntity
import retrofit2.Response
import retrofit2.http.GET

interface MemesApiService {

    @GET("get_memes")
    suspend fun getMemesData(): Response<ResponseEntity>
}