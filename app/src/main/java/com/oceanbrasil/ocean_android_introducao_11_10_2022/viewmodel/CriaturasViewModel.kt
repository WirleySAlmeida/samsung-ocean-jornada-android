package com.oceanbrasil.ocean_android_introducao_11_10_2022.viewmodel

import androidx.lifecycle.ViewModel
import com.oceanbrasil.ocean_android_introducao_11_10_2022.model.CriaturasRepository

class CriaturasViewModel : ViewModel() {
    // TODO: Colocar a lista de criaturas dentro do ViewModel
    // TODO: A partir disso, vamos carregar a RecyclerView com essa lista

    private val repository = CriaturasRepository()

    val criaturas = repository.criaturas
}