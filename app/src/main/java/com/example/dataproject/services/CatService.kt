package com.example.dataproject.services

import com.example.dataproject.models.MyCat
import retrofit2.Call
import retrofit2.http.GET

interface CatService{

    @GET("facts")
    fun getCatFacts () : Call<List<MyCat>>
}