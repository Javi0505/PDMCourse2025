package com.pdmtaller2.JavierCaceres_00068223.data.model

data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String
)

data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val categories: List<String>,
    val menu: List<Dish>
)