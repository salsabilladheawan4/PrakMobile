package com.example.saturnus_salsa.home.data.api

import com.example.saturnus_salsa.home.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}