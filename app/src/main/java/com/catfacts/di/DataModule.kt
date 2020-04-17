package com.catfacts.di

import com.catfacts.data.repository.CatRepositoryImpl
import com.catfacts.domain.repository.CatRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun provideRepository(repository: CatRepositoryImpl?): CatRepository?
}
