package com.pdmtaller2.JavierCaceres_00068223.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pdmtaller2.JavierCaceres_00068223.ui.navigations.OrdersScreenNavigation
import com.pdmtaller2.JavierCaceres_00068223.ui.navigations.RestaurantListScreenNavigation
import com.pdmtaller2.JavierCaceres_00068223.ui.navigations.SearchScreenNavigation


@Composable
fun CustomBottomBar(navController: NavHostController) {
    val navItems = listOf(
        "Restaurantes" to RestaurantListScreenNavigation,
        "Buscar" to SearchScreenNavigation,
        "Mis Ordenes" to OrdersScreenNavigation
    )
    var selectedItem by rememberSaveable { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E1E1E))
    ) {
        navItems.forEachIndexed { index, (label, screen) ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (selectedItem == index) Color(0xFF9DBDBA) else Color.Transparent)
                    .clickable {
                        selectedItem = index
                        navController.navigate(screen) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    color = if (selectedItem == index) Color(0xFFFFFFFF) else Color(0xFFB0B0B0)
                )
            }
        }
    }
}