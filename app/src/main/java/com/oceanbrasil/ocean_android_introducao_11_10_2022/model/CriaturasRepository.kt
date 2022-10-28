package com.oceanbrasil.ocean_android_introducao_11_10_2022.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.oceanbrasil.ocean_android_introducao_11_10_2022.model.api.CriaturaService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CriaturasRepository {
    val criaturas = MutableLiveData<List<Criatura>>()

    init {
        // Carregamento dos dados da API

        val retrofit = Retrofit.Builder()
            .baseUrl("https://backend-livro-android-casa-cod.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CriaturaService::class.java)

        val call = service.listar()

        call.enqueue(object : Callback<List<Criatura>> {
            override fun onResponse(
                call: Call<List<Criatura>>,
                response: Response<List<Criatura>>
            ) {
                val resultado = response.body()

                resultado?.let {
                    criaturas.value = it
                }
            }

            override fun onFailure(call: Call<List<Criatura>>, t: Throwable) {
                Log.e("CRIATURAS", "Falha na requisição", t)
            }
        })
    }
}