package com.pdmtaller2.JavierCaceres_00068223.ui.navigations

import kotlinx.serialization.Serializable

@Serializable
object RestaurantListScreenNavigation

@Serializable
object SearchScreenNavigation

@Serializable
object OrdersScreenNavigation

@Serializable
data class RestaurantDetailScreenNavigation(val id: Int)
