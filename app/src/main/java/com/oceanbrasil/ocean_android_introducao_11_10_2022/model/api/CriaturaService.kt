package com.oceanbrasil.ocean_android_introducao_11_10_2022.model.api

import com.oceanbrasil.ocean_android_introducao_11_10_2022.model.Criatura
import retrofit2.Call
import retrofit2.http.GET

interface CriaturaService {

    @GET("creature")
    fun listar() : Call<List<Criatura>>
}