package com.taller2.gala00098122.dummy

import com.taller2.gala00098122.model.Dish
import com.taller2.gala00098122.model.Restaurant

val DummyRestaurant = listOf(
  Restaurant(
    id = 1,
    name = "Pizza Place",
    description = "Las mejores pizzas artesanales de la ciudad",
    voteAverage = 6.751,
    imageUrl = "https://images.unsplash.com/photo-1611915365928-565c527a0590?q=80&w=1025",
    categories = listOf("Italiana", "Pizzas"),
    menu = listOf(
      Dish(
        id = 1,
        name = "Pizza Margarita",
        description = "Mozzarella, albahaca y tomate fresco",
        imageUrl = "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?q=80&w=781"
      ),
      Dish(
        id = 2,
        name = "Pizza Pepperoni",
        description = "Pepperoni con queso mozzarella derretido",
        imageUrl = "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?q=80&w=1176"
    )
  )
)
// ... agregar al menos 9 restaurantes más
)