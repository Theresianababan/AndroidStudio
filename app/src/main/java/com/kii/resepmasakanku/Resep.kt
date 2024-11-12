package com.kii.resepmasakanku

data class Resep(
    val name: String,
    val description: String,
    val photo: Int,
    val ingredients: String,
    val instructions: String
)