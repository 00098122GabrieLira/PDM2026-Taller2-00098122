package com.taller2.gala00098122.navegacion.routes

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
  @Serializable
  data object Restaurants : Routes()
  
  @Serializable
  data class Dishes(val restaurantId: Int) : Routes()
  
  @Serializable
  data object Search : Routes()
  
}
