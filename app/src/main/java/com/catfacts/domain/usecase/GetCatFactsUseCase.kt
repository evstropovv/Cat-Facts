package com.catfacts.domain.usecase

import com.catfacts.domain.mapper.DomainMapper
import com.catfacts.domain.model.CatFactDomainModel
import com.catfacts.domain.repository.CatRepository
import javax.inject.Inject

class GetCatFactsUseCase @Inject constructor(
    private val mapper: DomainMapper,
    private val repository: CatRepository
) {

    suspend fun execute(): CatFactDomainModel {
        return mapper.map(repository.getCatFact())
    }
}