package com.pdmtaller2.JavierCaceres_00068223.data.dummy

import com.pdmtaller2.JavierCaceres_00068223.data.model.Dish
import com.pdmtaller2.JavierCaceres_00068223.data.model.Restaurant

val restaurants = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Planet",
        description = "Especializados en pizza y comida italiana.",
        imageUrl = "https://i.pinimg.com/736x/cf/bc/6a/cfbc6ac81eacda3c43442ded3e71bc65.jpg",
        categories = listOf("Comida Rápida"),
        menu = listOf(
            Dish(1, "Pizza Pepperoni", "Clásica con queso mozzarella y pepperoni.", "https://images.unsplash.com/photo-1628840042765-356cda07504e?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGl6emElMjBwZXBwZXJvbml8ZW58MHx8MHx8fDA%3D"),
            Dish(2, "Lasagna", "Pasta al horno con carne y queso.", "https://media.istockphoto.com/id/543663322/photo/meat-lasagna.jpg?s=612x612&w=0&k=20&c=nYLF1yuCTxIMwQ0JjnAT3_fd7ZqsAds1RO4FOinimZ4=")
        )
    ),
    Restaurant(
        id = 2,
        name = "Burger King",
        description = "Hamburguesas a la parrilla y comida rápida.",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Burger_King_2020.svg/1200px-Burger_King_2020.svg.png",
        categories = listOf("Comida Rápida"),
        menu = listOf(
            Dish(1, "Whopper", "Hamburguesa clásica con carne a la parrilla.", "https://cdn.prod.website-files.com/631b4b4e277091ef01450237/65947cd2a2c28c35b5ca6fb1_Whopper%20w%20Cheese.png"),
            Dish(2, "Papas Fritas", "Crujientes por fuera, suaves por dentro.", "https://s3-eu-central-1.amazonaws.com/bk-uy-demo.menu.app/wp-media-folder-burger-king-uruguay//home/ubuntu/preview/menu-app/frontend/apps/marketing-website-wordpress-app/web/app/uploads/sites/27/PAPAS-GRANDES.png")
        )
    ),
    Restaurant(
        id = 3,
        name = "Tacos Hermanos",
        description = "Deliciosos tacos mexicanos tradicionales.",
        imageUrl = "https://mardo-uk.us.stackstaging.com/skilltec/wp-content/uploads/2023/03/Copy-of-Tacos-Hermanos_Logo_Versiones_Mesa-de-trabajo-1-1.png",
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(1, "Tacos al pastor", "Tacos con carne de cerdo y piña.", "https://upload.wikimedia.org/wikipedia/commons/b/b5/01_Tacos_al_Pastor.jpg"),
            Dish(2, "Quesadillas", "Tortillas rellenas de queso y guacamole.", "https://media.istockphoto.com/id/1137678835/es/foto/cerca-de-pollo-horneado-y-quesadillas-de-queso-servido-con-salsa-y-guacamole-en-placa-de-piedra.jpg?s=612x612&w=0&k=20&c=PO6-YrqSEXQH_4jXeHLLJTk9h1xrxvAWTpyHmcLWxQg=")
        )
    ),
    Restaurant(
        id = 4,
        name = "Sushi Itto",
        description = "Sushi fresco y platillos japoneses.",
        imageUrl = "https://mir-s3-cdn-cf.behance.net/projects/404/19881821.541bb271acfea.jpg",
        categories = listOf("Comida Asiática"),
        menu = listOf(
            Dish(1, "California Roll", "Roll con cangrejo, aguacate y pepino.", "https://media.istockphoto.com/id/115547349/es/foto/rollo-maki-california.jpg?s=612x612&w=0&k=20&c=PjOHRCoEyZx-WgtgAu8iiLkNy2Q_rOtHQaNTZKNaSn0="),
            Dish(2, "Sashimi", "Pescado crudo fresco.", "https://media.istockphoto.com/id/621899966/es/foto/sashimi-de-salm%C3%B3n-en-rodajas-deliciosa-comida-cruda-japonesa.jpg?s=612x612&w=0&k=20&c=eAe9bpG4FkjtPVEol8CIkh-rDzlk32U53LCqBKtYa6A=")
        )
    ),
    Restaurant(
        id = 5,
        name = "Alfresco",
        description = "Opciones saludables, vegetarianas y veganas.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJppAHGqAEx70LY5nJiTrtCCfV6EPqbNlGdg&s",
        categories = listOf("Comida Saludable", "Vegano"),
        menu = listOf(
            Dish(1, "Bowl de quinoa", "Con vegetales frescos y hummus.", "https://assets.tmecosys.com/image/upload/t_web_rdp_recipe_584x480_1_5x/img/recipe/ras/Assets/bdc253a0-ea6c-43a8-9483-e18cd48fdcc4/Derivates/01c80035-05c6-48ca-83d0-50171f065260.jpg"),
            Dish(2, "Ensalada detox", "Ensalada fresca con aderezo cítrico.", "https://assets.tmecosys.com/image/upload/t_web_rdp_recipe_584x480/img/recipe/ras/Assets/3E4D2EC3-B765-4143-8F64-AE92ED60859A/Derivates/7B5940D2-F98B-4B89-AD00-F07DC81D6DC9.jpg")
        )
    ),
    Restaurant(
        id = 6,
        name = "La Tecleña",
        description = "Postres deliciosos para cualquier antojo.",
        imageUrl = "https://pbs.twimg.com/profile_images/1808518097608847360/ReiViImq_400x400.jpg",
        categories = listOf("Postres y Dulces"),
        menu = listOf(
            Dish(1, "Pastel de chocolate", "Pastel húmedo con cobertura.", "https://media.istockphoto.com/id/1370520449/es/foto/rebanada-de-pastel-de-chocolate-con-glaseado.jpg?s=612x612&w=0&k=20&c=LvnbdEqWXwitC4utYXHtI_UBTZA_JuqmGL13c0Bm6fA="),
            Dish(2, "Cheesecake de fresa", "Con base de galleta y frutas.", "https://media.istockphoto.com/id/1205169550/es/foto/rebanada-de-tarta-de-queso-con-fresas.jpg?s=612x612&w=0&k=20&c=kM0QYaSzJa1cSyit1t0YGUt8wvF_PE-8HLSnBagE9Z8=")
        )
    ),
    Restaurant(
        id = 7,
        name = "Boba Luba ",
        description = "Bebidas refrescantes con perlas de tapioca.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpHN-SPiLcHF-OJHw9urSTaMF318YTtSGq3g&s",
        categories = listOf("Postres y Dulces"),
        menu = listOf(
            Dish(1, "Taro con tapioca", "Clásico bubble tea.", "https://media.istockphoto.com/id/497654828/photo/taro-bubble-tea.jpg?s=612x612&w=0&k=20&c=W3vU1FwU86UbX_G25w8PIC6apGewBJBcQLnOQi4fkxM="),
            Dish(2, "Matcha Latte", "Té verde japonés con leche vegetal.", "https://media.istockphoto.com/id/1325991061/es/foto/taza-de-espuma-de-leche-verde-matcha-latte-en-la-mesa-de-madera-en-la-cafeter%C3%ADa-tendencia-de.jpg?s=612x612&w=0&k=20&c=dAo-zBvgQxV4uWq3aqf6wDnqMuIcKNX96pYhTruyJUs=")
        )
    ),
    Restaurant(
        id = 8,
        name = "Pollo Campero",
        description = "Clásico salvadoreño de pollo frito con sabor único.",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/5/56/PolloCampero_Logo.png",
        categories = listOf("Comida Rápida"),
        menu = listOf(
            Dish(1, "2 piezas con papas", "Combo de 2 piezas de pollo con papas fritas y bebida.", "https://pbs.twimg.com/media/E9FD_sWXoAEWNcT.jpg"),
            Dish(2, "Camperitos", "Bocados de pollo empanizados con salsas.", "https://pbs.twimg.com/media/FTycM21X0AksIdK.jpg")
        )
    ),
    Restaurant(
        id = 9,
        name = "El Fogón Mexicano",
        description = "Auténtica comida mexicana con ingredientes locales.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStKYKgoFsEaQgAkWvcBCQGW_Nl79bqw_etlw&s",
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(1, "Tacos de res", "Tortillas rellenas de res.", "hhttps://media.istockphoto.com/id/1430849921/es/foto/orden-de-tacos-closeup.jpg?s=612x612&w=0&k=20&c=OUrSGX2P6UlyrD13G8QJ_mRQ_d5luWEm2JJRx8q1D4M="),
            Dish(2, "Elote loco mexicano", "Elote con mayonesa, queso, chile y limón.", "https://t3.ftcdn.net/jpg/04/50/54/44/360_F_450544433_C424VWPiTvLup3pChoKPR0y7BoHWi2d1.jpg")
        )
    ),
    Restaurant(
        id = 10,
        name = "Taquería Los Sanchez",
        description = "Taquería estilo callejero con sabor casero.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtPQ1_Z4mn4obfvpyDNu_M3AkoxblqbszkfA&s",
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(1, "Nachos con carne", "Totopos con frijoles, queso, crema y carne.", "https://media.istockphoto.com/id/2162507031/es/foto/nachos-de-ma%C3%ADz-con-mucha-carne-picada-guisada-queso-cheddar-y-chile-jalape%C3%B1o-servidos-con.jpg?s=612x612&w=0&k=20&c=PmL75EU6dAq1P2plFRC1B1YvBr-FalcEVicUh43Ki94="),
            Dish(2, "Burrito de pollo", "Burrito relleno de pollo a la plancha con verduras.", "https://campollo.com/wp-content/uploads/2023/06/burritos-de-pollo-y-vegetales.jpg")
        )
    ),
    Restaurant(
        id = 11,
        name = "China Wok",
        description = "Salteados asiáticos rápidos y personalizables.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTg71mWaO0Ncay-Q9kAs5QlpygJLJLn07SfDA&s",
        categories = listOf("Comida Asiática"),
        menu = listOf(
            Dish(1, "Wok de camarón", "Noodles salteados con camarón y vegetales.", "https://www.vivo.cl/wp-content/uploads/2022/10/recetas-pasta-wok-vivo-mob.jpg"),
            Dish(2, "Arroz frito mixto", "Con pollo, res, vegetales y soya.", "https://img-global.cpcdn.com/recipes/f22b3ee400e0e7b9/1200x630cq70/photo.jpg")
        )
    ),
    Restaurant(
        id = 12,
        name = "Sushi Time",
        description = "Sushi fresco, fusión con sabores tropicales.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSQVCFVejFGiG6nGsHpAFSLEzLm-SRUZCmNw&s",
        categories = listOf("Comida Asiática", "Comida Saludable"),
        menu = listOf(
            Dish(1, "Roll tropical", "Sushi con mango, camarón y aguacate.", "https://cdn7.kiwilimon.com/recetaimagen/41048/640x640/55425.jpg.jpg"),
            Dish(2, "Yakimeshi", "Arroz frito japonés con vegetales.", "https://imag.bonviveur.com/yakimeshi-o-arroz-frito-japones-en-bol-con-palillos.jpg")
        )
    ),
    Restaurant(
        id = 13,
        name = "Go Green",
        description = "Comidas bajas en calorías y altas en sabor.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_pjfZIxMV-8FVdQwDu517UDrxNjnqWiQ2jw&s",
        categories = listOf("Comida Saludable", "Vegano"),
        menu = listOf(
            Dish(1, "Pollo a la plancha con vegetales", "Ideal para almuerzo nutritivo.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBa5qIgaS98azIkZAwfk43BeG-fG92lvbUaw&s"),
            Dish(2, "Ensalada de atún", "Con garbanzos, tomate y lechuga.", "https://media.istockphoto.com/id/1420333440/es/foto/ensalada-de-at%C3%BAn-con-lechuga-aguacate-y-tomate.jpg?s=612x612&w=0&k=20&c=ziYkFNU8V_c3o0rmK5oaCIsUXRNRNRPUhCG22jc_vG4=")
        )
    ),
    Restaurant(
        id = 14,
        name = "Kako Cakes",
        description = "Postres caseros, ideales para acompañar el café.",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSse9YwlGCJyfrO14IqC8p_sWmICN2wKo5IXg&s",
        categories = listOf("Postres y Dulces", "Vegano"),
        menu = listOf(
            Dish(1, "Pastel tres leches", "Clásico pastel salvadoreño con cobertura de crema.", "https://media.istockphoto.com/id/542696446/es/foto/tres-pasteles-de-leche-con-coco-postre-tradicional-de-am%C3%A9rica-latina.jpg?s=612x612&w=0&k=20&c=4luZxOOrHf51XgIcgAYY4WyO6b6nsasbKd1f0tr9Avo="),
            Dish(2, "Empanadas de plátano", "Plátano relleno de leche o frijol, frito.", "https://mojo.generalmills.com/api/public/content/-wL0UKSw8kyn1CRiZmrwHg_gmi_hi_res_jpeg.jpeg?v=40a927c3&t=16e3ce250f244648bef28c5949fb99ff")
        )
    )






)
