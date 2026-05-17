package com.taller2.gala00098122.model

data class ShoppingCart(
  val dish: Dish,
  val quantity: Int,
  val restaurantId: Int,
  val restaurantName: String
)