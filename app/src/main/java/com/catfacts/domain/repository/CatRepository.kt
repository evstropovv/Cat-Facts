package com.catfacts.domain.repository

import com.catfacts.data.models.CatFactDataModel

interface CatRepository {
    suspend fun getCatFact(): CatFactDataModel
}