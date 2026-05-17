package com.taller2.gala00098122.ui.screens.searchScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taller2.gala00098122.data.repositories.restaurantRepository.RestaurantApiRepository
import com.taller2.gala00098122.data.repositories.restaurantRepository.RestaurantRepository
import com.taller2.gala00098122.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
  private val restaurantRepository: RestaurantRepository = RestaurantApiRepository()
  
  private val _allRestaurants = MutableStateFlow<List<Restaurant>>(emptyList())
  
  private val _searchQuery = MutableStateFlow("")
  val searchQuery = _searchQuery.asStateFlow()
  
  private val _searchResults = MutableStateFlow<List<Restaurant>>(emptyList())
  val searchResults = _searchResults.asStateFlow()
  
  private val _loading = MutableStateFlow(true)
  val loading = _loading.asStateFlow()
  
  init {
    loadRestaurants()
  }
  
  fun loadRestaurants() {
    viewModelScope.launch {
      _loading.value = true
      
      try {
        val restaurants = restaurantRepository.getRestaurants()
        _allRestaurants.value = restaurants
        _searchResults.value = emptyList()
      } catch (e: Exception) {
        _allRestaurants.value = emptyList()
        _searchResults.value = emptyList()
      } finally {
        _loading.value = false
      }
    }
  }
  
  fun updateSearchQuery(query: String) {
    _searchQuery.value = query
    performSearch(query)
  }
  
  private fun performSearch(query: String) {
    if (query.isBlank()) {
      _searchResults.value = emptyList()
      return
    }
    
    val lowerCaseQuery = query.lowercase()
    
    val filtered = _allRestaurants.value.filter { restaurant ->
      
      val matchesRestaurantName = restaurant.name.lowercase().contains(lowerCaseQuery)
      
      val matchesDishName = restaurant.menu.any { dish ->
        dish.name.lowercase().contains(lowerCaseQuery)
      }
      
      matchesRestaurantName || matchesDishName
    }
    
    _searchResults.value = filtered
  }
}