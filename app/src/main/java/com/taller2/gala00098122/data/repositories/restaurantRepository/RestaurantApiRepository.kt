package com.taller2.gala00098122.data.repositories.restaurantRepository

import com.taller2.gala00098122.dummy.DummyRestaurant
import com.taller2.gala00098122.model.Restaurant
import kotlinx.coroutines.delay

class RestaurantApiRepository: RestaurantRepository {
  override suspend fun getRestaurants(): List<Restaurant> {
    delay(2000)
    return DummyRestaurant
  }
  
  override suspend fun getRestaurantById(id: Int): Restaurant? {
    delay(5000)
    return DummyRestaurant.find { it.id == id }
  }
}