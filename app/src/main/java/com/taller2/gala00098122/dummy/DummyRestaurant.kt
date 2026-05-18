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
  ),
  Restaurant(
    id = 2,
    name = "La oveja negra",
    description = "Nuestra cocina evoluciona con el día: con desayunos que reconfortan, almuerzos y cenas que exploran nuevas interacciones, terminando en brunch familiar los fines de semana, donde se celebra la familia.",
    voteAverage = 4.96,
    imageUrl = "https://resizer.otstatic.com/v4/photos/78140357-2?width=290&height=515&format=avif",
    categories = listOf("Brunch", "Lunch", "Cena", "Bebidas"),
    menu = listOf(
      Dish(
        id = 3,
        name = "Oveja Francesa",
        description = "Tostada de pan brioche con corteza de panela, mix de nueces tostadas y mantequilla quemada (avellanada), servida con nuestro sirope de maple preparado en casa",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZBK_tW2B9rR5kKK-GBL51Q649jcjYqu1v0A&s"
      ),
      Dish(
        id = 4,
        name = "Clasico de la casa",
        description = "Huevos revueltos y cremosos, frijoles molidos, crema nacional y plátano frito.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRTH_DG1y1VSypH-uKf81Ua6Xg5csFbzLpWw&s"
      ),
      Dish(
        id = 5,
        name = "Kimcheese",
        description = "Pan de masa madre, mix de quesos, mayo y kimchi de la casa.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS17J8ouJJby8ZQ2KLnC1vVTKyzdVW8wg2Mbw&s"
      )
    )
  ),
  Restaurant(
    id = 3,
    name = "Brutto",
    description = "Nuestro enfoque no es solo comida asiática e internacional. Ofrecemos un menú de sushi, risottos y not so small eats así como un menú de drinks y vinos internacionales",
    voteAverage = 4.74,
    imageUrl = "https://static.wixstatic.com/media/9b5899_fff852d230554310bb9ede326d429a33~mv2.jpg/v1/fit/w_2500,h_1330,al_c/9b5899_fff852d230554310bb9ede326d429a33~mv2.jpg",
    categories = listOf("Brunch", "Lunch", "Cena", "Bebidas"),
    menu = listOf(
      Dish(
        id = 6,
        name = "Dragon brutto",
        description = "Langostino Tempura / Salmón / Kani / Aguacate / Philadelphia / Salsa Dragon / Ikura",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrKmG66OCTOTkCO3SJ4KPtvcHj9x4PASqHCA&s"
      ),
      Dish(
        id = 7,
        name = "El oso maki",
        description = "Kani Osaki / Queso Philadelphia / Hilos de Masa Philo Crocante / Tartar de Salmón (Hosomaki Style)",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1ynR1oywNuieM7jXq0g2663RooBe_F0DyIg&s "
      ),
      Dish(
        id = 8,
        name = "Terminator",
        description = "Atún / Spicy Mayo / Cebollina / Aceite de Trufas / Hilos de Papa Crocantes / Papel de Soya",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHxjG3E5P9XnTIfoD-HSP4cfNe7oP95ZwiAQ&s"
      )
    )
  ),
  Restaurant(
    id = 4,
    name = "María Bonita Brunch & Drunch",
    description = "Más que un restaurante, soy una experiencia. Un espacio en San Salvador donde la creatividad culinaria y la coctelería de autor se fusionan para brindar con intención.",
    voteAverage = 4.66,
    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJ5n3ebuC0Q359Ux0aK8HeglYXpns58RU4Lw&s",
    categories = listOf("Brunch", "Lunch", "Cena", "Drunch"),
    menu = listOf(
      Dish(
        id = 9,
        name = "Benedictino Bacon",
        description = "Huevos pochados, crocante tocino, cremoso aguacate, bañados en salsa holandesa",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSy4c158eFTl4qzJ3DjRCYtlPnrWg5rOHNs4g&s"
      ),
      Dish(
        id = 10,
        name = "Salmón Nórdico",
        description = "Bagel oscuro crujiente con salmón chileno, berro picante, queso feta, cebolla morada y aderezo de yogurt con pimientos tatemados",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQLgwF81yTVKwLAf_wpKSMzx4AWch8gjbMiQ&s"
      ),
      Dish(
        id = 11,
        name = "Candy",
        description = "Cremoso helado de vainilla con fresas frescas, espolvoreado con una fina capa de azúcar glass con topping de chocolate disfruta del capricho de estas tres texturas de sabores",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRozatyRdAnKdsqCtDtKd2t9Z4ELiwz29JmCg&s"
      )
    )
  ),
  Restaurant(
    id = 5,
    name = "Casa Fuego x Bendito Fuego",
    description = "Crear historias y rituales, generar calor y alimento, Del fuego somos y al fuego volveremos. Bienvenidos a la comunidad del fuego, somos los guardianes del fuego.",
    voteAverage = 4.49,
    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTL0Q1gdXhqtK4a1QhoHCFnkhUefnV__1ppAA&s",
    categories = listOf("Bocas/entradas", "Sanguches", "Guarniciones", "Proteina"),
    menu = listOf(
      Dish(
        id = 12,
        name = "Papas de feria",
        description = "Papas Fritas • Alioli de la Casa • Queso Duro Blando • Tocino Crocante • Cilantro • Achiote",
        imageUrl = "https://comedera.com/wp-content/uploads/sites/9/2022/11/papas-fritas-con-queso-cheddar-PG_PFCQCY30320002.jpg?fit=720,480&crop=0px,38px,720px,404px"
      ),
      Dish(
        id = 13,
        name = "Empanada de carne",
        description = "Pepperoni con queso mozzarella derretido",
        imageUrl = "Carne cortada a cuchillo • Comino • Hierbas Locales • Achiote • Cebolla Caramelizada"
      ),
      Dish(
        id = 14,
        name = "Puyazo Guindado",
        description = "Puyazo Prime americano colgado a fuego abierto por horas y luego madurado en húmedo por una semana. Pasado por las brasas de nuestro horno Vesuvio. Lo servimos en su punto, como debe ser.",
        imageUrl = " https://images.squarespace-cdn.com/content/v1/66e91655b96c786ed2f4e932/86ba79f2-087a-4f67-bfb0-0dc03ee9d43a/DSC07564.jpg"
      )
    )
  ),
  Restaurant(
    id = 6,
    name = "Bubba's El Salvador",
    description = "Desde cócteles y ceviches, carpaccios, po'boys y otros platillos con mariscos hasta nuestros famosos boils de mariscos por libra los cuales puedes combinarlos con nuestras salsas a base de mantequilla.",
    voteAverage = 4.35,
    imageUrl = "https://bubbassv.com/wp-content/uploads/2023/06/280584613_1457081251391313_5176838345955707726_n-950x633.png",
    categories = listOf("Sopas y ensaladas", "Entradas", "Ceviches", "Infantiles"),
    menu = listOf(
      Dish(
        id = 15,
        name = "Avo shrimp toast",
        description = "Tostones de plátano con camarones en salsa rosada y aguacate.",
        imageUrl = "https://bubbassv.com/wp-content/uploads/2023/06/Avo-Shrimp-Toast-2-scaled-e1687391080521.jpg"
      ),
      Dish(
        id = 16,
        name = "Chiken Burguer",
        description = "Delicioso pan suave de hamburguesa con filete de pollo empanizado o a la plancha, con coleslaw, tomate y lechuga fresca.",
        imageUrl = "https://bubbassv.com/wp-content/uploads/2023/08/DSC8417-scaled.jpg"
      ),
      Dish(
        id = 17,
        name = "Po’Boy tradicional de camarón",
        description = "camarones empanizados sobre una cama de lechuga fresca y tomate en un baguette recién horneado bañado con nuestra salsa Po’ Boy especial.",
        imageUrl = "https://bubbassv.com/wp-content/uploads/2023/06/Poboy-camaron-1.png"
      )
    )
  ),
  Restaurant(
    id = 7,
    name = "Hacienda Real",
    description = "Déjese consentir por la calidez de nuestra gente, nuestro servicio excepcional, lo auténtico del ambiente, y los sabores criollos de nuestra cocina. Un verdadero reencuentro con nuestra historia colonial",
    voteAverage = 4.75,
    imageUrl = "https://haciendareal.com.sv/wp-content/uploads/2025/11/HACIENDA-REAL.jpg ",
    categories = listOf("Ensaladas", "Hamburguezas", "Cortes de hacienda", "Cortes importados USDA"),
    menu = listOf(
      Dish(
        id = 18,
        name = "Chicharroneros de la Hacienda",
        description = "Chicharrones hechos en casa con nuestra receta especial, acompañados con curtido de rábano, curtido picante de cebolla, guacamole chapín, casamiento y tortillas del comal.",
        imageUrl = "https://assets.isu.pub/document-structure/230310224553-a99c3f7ed13b103e5f3e30e473c46ab6/v1/a694265044f6a351711326d0c6e2e307.jpeg"
      ),
      Dish(
        id = 19,
        name = "El Choricero Real",
        description = "Chorizo uruguayo y longaniza, acompañado de frijoles chapines, guacamole chapín, cebollines a las brasas y tortillas del comal.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsZXd68in85gPqSTMmWVaywGfPJb5IMfgbng&s"
      ),
      Dish(
        id = 20,
        name = "Campesina",
        description = "Espinaca, mezcla de lechugas de la huerta, cebolla morada, arándanos, fresas frescas, manzana verde, almendras caramelizadas, cristales de papaya, queso fresco y reducción de vinagre balsámico.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxT4YlsQ324oUalvT4fItfrcbRQo2WsDATAQ&s"
      )
    )
  ),
  Restaurant(
    id = 8,
    name = "El Lomo y La Aguja",
    description = "Con cada bocado, compartimos nuestra historia y nuestro sueño de llevar la carne a todos los corazones amantes de la carne",
    voteAverage = 4.58,
    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRe-vNXXU4AYeEUyiFSQHqh9e-F-1nm18jPw&s",
    categories = listOf("Para boquear", "Sopas y ensaladas", "Los mastodontes", "Parrilladas"),
    menu = listOf(
      Dish(
        id = 21,
        name = "Boqueado",
        description = "Una deliciosa combinación de frijoles fritos, guacamol, cuajada, chorizo gaucho, tostones y tortilla frita",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaZ32s4OkhveyP81E029a710myuqSQkAwpUw&s"
      ),
      Dish(
        id = 22,
        name = "Alitas",
        description = "8 alitas bañadas en dos opciones de salsas creamy buffalo o BBQ, acompañadas de apio, zanahoria y salsa ranch.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAYEdZ4f2JJ9q0dstL3rZyXxi3rTU0H2jd2Q&s"
      ),
      Dish(
        id = 23,
        name = "Chicharrones",
        description = "Trozos de panceta, acompañados de guacamole, frijoles fritos, tortilla tostada y curtido de rábano",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZHzt7UpuRFL46ngxoMBVWINcvws-mKAOEyA&s"
      )
    )
  ),
  Restaurant(
    id = 9,
    name = "Tolo's grill restaurante",
    description = "Combinamos el auténtico sabor mediterráneo con un entorno inmejorable junto al mar. Disfruta de nuestras especialidades, desde paellas tradicionales hasta carnes a la brasa preparadas con dedicación.",
    voteAverage = 4.29,
    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQICveHJARVVpEzXM6zQ53KEF0zZ_mOyYyJlA&s",
    categories = listOf("Entradas y tapas", "Ensaladas", "Grill carne", "Pescado"),
    menu = listOf(
      Dish(
        id = 24,
        name = "Chuletitas de cordeo",
        description = "Al carbón de encina con pimientos y ajos fritos",
        imageUrl = "https://bistrobadia.de/wp-content/uploads/2024/04/lammkotelett-13-500x500.jpg"
      ),
      Dish(
        id = 25,
        name = "Costillar de cerdo BBQ",
        description = "Glaseado con salsa BBQ made in Tolo's",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQF3ac1Jovqk-qDRNIEsxOSA8agGOD2w4ai6A&s"
      ),
      Dish(
        id = 26,
        name = "Pollo asado",
        description = "Marinado con especias locales, pimentón y limón ahumado mallorquín",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9albOgmhwqd0T3XV2qDWDju-NQi1XTtNtqA&s"
      )
    )
  ),
  Restaurant(
    id = 10,
    name = "Los Cebollines",
    description = "Cadena líder en cocina mexicana distinguiéndonos de los demás restaurantes por nuestro ambiente familiar y agradable, servicio cordial, personalizado y precios accesibles, logrando así la satisfacción de nuestros consumidores.",
    voteAverage = 4.01,
    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBA5gD60LThY6LlhnNaWOCPPw8M2NwnoO_2Q&s",
    categories = listOf("Botanas para picar", "Sopas y caldos", "Tacos, tortas y gringas", "Especialidades mexicanas"),
    menu = listOf(
      Dish(
        id = 27,
        name = "Nachos al pastor",
        description = "Crujientes Nachos bañados en salsa verde con trozos de piña y carne Al Pastor. Decorados con salsa chipotle, crema, rodajas de jalapeño, cebolla curtida, guacamole, cebolla y cilantro.",
        imageUrl = "https://d31f1ehqijlcua.cloudfront.net/n/a/4/5/0/a4508730f1d5c6699a0e877dee4bbf57a21ba3c8_Chips_333193_03.jpg"
      ),
      Dish(
        id = 28,
        name = "Chicharrones de villa",
        description = "Chicharrones criollos ahogados en queso fundido y tu salsa preferida, servido en molcajete caliente.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbyMHcE7OP64cWo9uo_9q1SBotJheFZfsnYA&s"
      ),
      Dish(
        id = 29,
        name = "Jinetes (Plato mixto)",
        description = "Alitas de pollo bañanadas en salsa guajillo, 6 enrollones (tacos de tortilla de harina rellenos de papa y chorizo), y 4 panuchos (tortillas de maíz tostadas con frijol: 2 de Cochinita Pibil y 2 de Pollo Pibil), y chorizo argentino. Acompañado de salsa de aguacate, chile de árbol y salsa guajillo.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8mKcSWDWjp8e4xxjftFoTtZJPfnF-f8Udbg&s"
      )
    )
  )
)