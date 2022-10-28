package com.oceanbrasil.ocean_android_introducao_11_10_2022.model

data class Criatura(
    val number : Int,
    val name : String,
    val image : String,
    val legendary : Boolean,
    val evolveTo : Criatura?
)