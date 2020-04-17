package com.catfacts.data.repository

import com.catfacts.data.ApiRetrofit
import com.catfacts.data.mapper.DataMapper
import com.catfacts.data.models.CatFactDataModel
import com.catfacts.domain.repository.CatRepository
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val apiRetrofit: ApiRetrofit,
    private val mapper: DataMapper
) : CatRepository {
    override suspend fun getCatFact(): CatFactDataModel {
        val catFactDTO = apiRetrofit.getRandomCatFact()
        val catPictureDTO = apiRetrofit.getRandomPicture()
        return mapper.map(catFactDTO, catPictureDTO.first())
    }
}