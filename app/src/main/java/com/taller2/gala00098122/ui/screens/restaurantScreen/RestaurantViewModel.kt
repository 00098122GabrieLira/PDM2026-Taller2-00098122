package com.taller2.gala00098122.ui.screens.restaurantScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taller2.gala00098122.data.repositories.restaurantRepository.RestaurantApiRepository
import com.taller2.gala00098122.data.repositories.restaurantRepository.RestaurantRepository
import com.taller2.gala00098122.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RestaurantViewModel : ViewModel() {
  private val restaurantRepository: RestaurantRepository = RestaurantApiRepository()
  
  private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
  val restaurants = _restaurants.asStateFlow()
  
  private val _loading = MutableStateFlow(true)
  val loading = _loading.asStateFlow()
  
  private val _restaurantsByCategory = MutableStateFlow<Map<String, List<Restaurant>>>(emptyMap())
  val restaurantsByCategory = _restaurantsByCategory.asStateFlow()
  
  init {
    loadRestaurants()
  }
  
  fun loadRestaurants() {
    viewModelScope.launch {
      _loading.value = true
      
      try {
        val restaurants = restaurantRepository.getRestaurants()
        _restaurants.value = restaurants
        
        val grouped = groupRestaurantsByCategory(restaurants)
        _restaurantsByCategory.value = grouped
        
      } catch (e: Exception) {
        _restaurants.value = emptyList()
        _restaurantsByCategory.value = emptyMap()
      } finally {
        _loading.value = false
      }
    }
  }
  
  private fun groupRestaurantsByCategory(restaurants: List<Restaurant>): Map<String, List<Restaurant>> {
    val grouped = mutableMapOf<String, MutableList<Restaurant>>()
    
    restaurants.forEach { restaurant ->
      restaurant.categories.forEach { category ->
        grouped.getOrPut(category) { mutableListOf() }.add(restaurant)
      }
    }
    
    return grouped
  }
}