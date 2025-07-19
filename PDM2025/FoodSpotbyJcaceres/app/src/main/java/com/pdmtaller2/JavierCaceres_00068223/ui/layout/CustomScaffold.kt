package com.pdmtaller2.JavierCaceres_00068223.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.JavierCaceres_00068223.ui.navigations.*
import com.pdmtaller2.JavierCaceres_00068223.ui.screens.RestaurantDetailScreen
import com.pdmtaller2.JavierCaceres_00068223.ui.screens.RestaurantsListScreen
import com.pdmtaller2.JavierCaceres_00068223.ui.screens.SearchScreen

@Composable
fun CustomScaffold() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            CustomTopBar("FoodSpot by Jcaceres")
        },
        bottomBar = {
            CustomBottomBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RestaurantListScreenNavigation,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<RestaurantListScreenNavigation> {
                RestaurantsListScreen(
                    onRestaurantClick = { id ->
                        navController.navigate(RestaurantDetailScreenNavigation(id))
                    }
                )
            }
            composable<SearchScreenNavigation> {
                SearchScreen { id ->
                    navController.navigate(RestaurantDetailScreenNavigation(id))
                }
            }
            composable<OrdersScreenNavigation> {
                Text("Pantalla de órdenes",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp))
            }
            composable<RestaurantDetailScreenNavigation> { backStackEntry ->
                val restaurantId = backStackEntry.arguments?.getInt("id") ?: 0
                RestaurantDetailScreen(restaurantId)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomScaffoldPreview() {
    CustomScaffold()
}
