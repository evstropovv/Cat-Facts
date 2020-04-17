package com.catfacts.data

import com.catfacts.data.models.CatFactDTO
import com.catfacts.data.models.CatPictureDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiRetrofit {

    @GET("/fact/")
    suspend fun getRandomCatFact(): CatFactDTO

    @Headers(value = ["x-api-key: $PICTURE_API_KEY"])
    @GET("https://api.thecatapi.com/v1/images/search")
    suspend fun getRandomPicture(): List<CatPictureDTO>
}