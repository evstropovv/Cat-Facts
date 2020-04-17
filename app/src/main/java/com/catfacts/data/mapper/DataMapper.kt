package com.catfacts.data.mapper

import com.catfacts.data.models.CatFactDTO
import com.catfacts.data.models.CatFactDataModel
import com.catfacts.data.models.CatPictureDTO
import javax.inject.Inject

class DataMapper @Inject constructor(){
    fun map(catFactDto: CatFactDTO?, catPictureDTO: CatPictureDTO? ) =
        CatFactDataModel(catFactDto?.fact?:"", catPictureDTO?.url?:"")
}