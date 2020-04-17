package com.catfacts.domain.mapper

import com.catfacts.data.models.CatFactDataModel
import com.catfacts.domain.model.CatFactDomainModel
import javax.inject.Inject

class DomainMapper @Inject constructor() {
    fun map(fact: CatFactDataModel)= CatFactDomainModel(fact.fact, fact.pictureUrl)
}