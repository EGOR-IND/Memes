package com.egor.memes.data.repository

import com.egor.memes.data.entity.MemeEntity
import com.egor.memes.data.service.MemesApiService
import com.egor.memes.util.DataResult

class MemesRepository(private val memesApiService: MemesApiService) {
    suspend fun getMemesData(): DataResult<List<MemeEntity>> {
        return try {
            val response = memesApiService.getMemesData()
            if (response.isSuccessful && response.body()?.success == true) {
                DataResult.DataSuccess(response.body()?.data?.memes ?: emptyList())
            } else {
                DataResult.DataError("error in loading data")
            }
        } catch (e: Exception) {
            DataResult.DataError("error in loading data")
        }
    }
}