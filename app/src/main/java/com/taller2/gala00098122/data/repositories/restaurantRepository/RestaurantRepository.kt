package com.taller2.gala00098122.data.repositories.restaurantRepository

import com.taller2.gala00098122.model.Restaurant

interface RestaurantRepository {
  suspend fun getRestaurants(): List<Restaurant>
  suspend fun getRestaurantById(id: Int): Restaurant?
}