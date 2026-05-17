package com.taller2.gala00098122.ui.screens.dishScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taller2.gala00098122.data.repositories.restaurantRepository.RestaurantApiRepository
import com.taller2.gala00098122.data.repositories.restaurantRepository.RestaurantRepository
import com.taller2.gala00098122.dummy.DummyRestaurant
import com.taller2.gala00098122.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DishViewModel : ViewModel() {
  private val restaurantRepository: RestaurantRepository = RestaurantApiRepository()
  
  private val _restaurant = MutableStateFlow<Restaurant?>(null)
  val restaurant = _restaurant.asStateFlow()
  
  private val _isLoading = MutableStateFlow(true)
  val isLoading = _isLoading.asStateFlow()
  
  fun loadDishes(restaurantId: Int) {
    viewModelScope.launch {
      _isLoading.value = true
      try {
        _restaurant.value = restaurantRepository.getRestaurantById(restaurantId)
      } catch (e: Exception) {
        _restaurant.value = null
      } finally {
        _isLoading.value = false
      }
    }
  }
}