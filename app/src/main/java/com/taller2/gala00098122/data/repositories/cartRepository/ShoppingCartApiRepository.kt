package com.taller2.gala00098122.data.repositories.cartRepository

import com.taller2.gala00098122.model.Dish
import com.taller2.gala00098122.model.ShoppingCart
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ShoppingCartApiRepository : ShoppingCartRepository {
  
  private val _cartItems = MutableStateFlow<List<ShoppingCart>>(emptyList())
  
  override suspend fun getCartItems(): List<ShoppingCart> {
    delay(100)
    return _cartItems.value
  }
  
  override suspend fun addItem(dish: Dish, restaurantId: Int, restaurantName: String) {
    delay(100)
    val currentItems = _cartItems.value.toMutableList()
    val existingIndex = currentItems.indexOfFirst { it.dish.id == dish.id }
    
    if (existingIndex != -1) {
      val existingItem = currentItems[existingIndex]
      currentItems[existingIndex] = existingItem.copy(
        quantity = existingItem.quantity + 1
      )
    } else {
      currentItems.add(
        ShoppingCart(
          dish = dish,
          quantity = 1,
          restaurantId = restaurantId,
          restaurantName = restaurantName
        )
      )
    }
    _cartItems.value = currentItems
  }
  
  override suspend fun removeItem(dishId: Int) {
    delay(100)
    _cartItems.value = _cartItems.value.filter { it.dish.id != dishId }
  }
  
  override suspend fun updateQuantity(dishId: Int, quantity: Int) {
    delay(100)
    if (quantity <= 0) {
      removeItem(dishId)
      return
    }
    
    val currentItems = _cartItems.value.toMutableList()
    val index = currentItems.indexOfFirst { it.dish.id == dishId }
    if (index != -1) {
      currentItems[index] = currentItems[index].copy(quantity = quantity)
      _cartItems.value = currentItems
    }
  }
  
  override suspend fun clearCart() {
    delay(100)
    _cartItems.value = emptyList()
  }
  
  override suspend fun getTotalItems(): Int {
    delay(50)
    return _cartItems.value.sumOf { it.quantity }
  }
  
  override fun observeCartItems(): Flow<List<ShoppingCart>> {
    return _cartItems.asStateFlow()
  }
}
