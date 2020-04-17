package com.catfacts.di

import com.catfacts.presentation.MainActivity
import com.catfacts.presentation.main.MainFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(main: MainActivity)
    fun inject(mainFragment: MainFragment)

}