package com.taller2.gala00098122.ui.screens.shoppingCartScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taller2.gala00098122.data.repositories.cartRepository.ShoppingCartApiRepository
import com.taller2.gala00098122.data.repositories.cartRepository.ShoppingCartRepository
import com.taller2.gala00098122.model.Dish
import com.taller2.gala00098122.model.ShoppingCart
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShoppingCartViewModel : ViewModel() {
  private val cartRepository: ShoppingCartRepository = ShoppingCartApiRepository()
  
  private val _cartItems = MutableStateFlow<List<ShoppingCart>>(emptyList())
  val cartItems = _cartItems.asStateFlow()
  
  private val _loading = MutableStateFlow(true)
  val loading = _loading.asStateFlow()
  
  private val _totalItems = MutableStateFlow(0)
  val totalItems = _totalItems.asStateFlow()
  
  init {
    loadCartItems()
    observeCartChanges()
  }
  
  fun loadCartItems() {
    viewModelScope.launch {
      _loading.value = true
      try {
        _cartItems.value = cartRepository.getCartItems()
        updateTotals()
      } finally {
        _loading.value = false
      }
    }
  }
  
  private fun observeCartChanges() {
    viewModelScope.launch {
      cartRepository.observeCartItems().collect { items ->
        _cartItems.value = items
        updateTotals()
      }
    }
  }
  
  private suspend fun updateTotals() {
    _totalItems.value = cartRepository.getTotalItems()
  }
  
  fun addToCart(dish: Dish, restaurantId: Int, restaurantName: String) {
    viewModelScope.launch {
      cartRepository.addItem(dish, restaurantId, restaurantName)
    }
  }
  
  fun removeFromCart(dishId: Int) {
    viewModelScope.launch {
      cartRepository.removeItem(dishId)
    }
  }
  
  fun updateQuantity(dishId: Int, quantity: Int) {
    viewModelScope.launch {
      cartRepository.updateQuantity(dishId, quantity)
    }
  }
  
  fun clearCart() {
    viewModelScope.launch {
      cartRepository.clearCart()
    }
  }
}