package com.pdmcourse.spotlyfe.data.model

import com.pdmcourse.spotlyfe.data.database.entities.PlaceEntity

data class Place(
  val id: Int = 0,
  val name: String,
  val remark: String,
  val latitude: Double,
  val longitude: Double,
)
// Convert Place to PlaceEntity
fun Place.toDatabase(): PlaceEntity {
    return PlaceEntity(
        id = id,
        name = name,
        remark = remark,
        latitude = latitude,
        longitude = longitude
    )
}