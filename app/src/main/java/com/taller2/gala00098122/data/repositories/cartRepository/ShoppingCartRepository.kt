package com.taller2.gala00098122.data.repositories.cartRepository

import com.taller2.gala00098122.model.Dish
import com.taller2.gala00098122.model.ShoppingCart
import kotlinx.coroutines.flow.Flow

interface ShoppingCartRepository {
  suspend fun getCartItems(): List<ShoppingCart>
  suspend fun addItem(dish: Dish, restaurantId: Int, restaurantName: String)
  suspend fun removeItem(dishId: Int)
  suspend fun updateQuantity(dishId: Int, quantity: Int)
  suspend fun clearCart()
  suspend fun getTotalItems(): Int
  
  fun observeCartItems(): Flow<List<ShoppingCart>>
}