package com.taller2.gala00098122.model

data class Restaurant(
  val id: Int,
  val name: String,
  val description: String,
  val imageUrl: String,
  val categories: List<String>,
  val menu: List<Dish>
)