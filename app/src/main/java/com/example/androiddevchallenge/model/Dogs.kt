package com.example.androiddevchallenge.model

data class Dog(
    val name: String,
    val race: String,
    val height: String,
    val weight: String,
    val imageUrl: String,
    val description: String
)

val dogsList = listOf(
    Dog("A", "", "", "", "", "")
)
