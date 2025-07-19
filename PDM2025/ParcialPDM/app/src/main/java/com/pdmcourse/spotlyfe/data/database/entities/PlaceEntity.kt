package com.pdmcourse.spotlyfe.data.database.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import com.pdmcourse.spotlyfe.data.model.Place
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "places")
data class PlaceEntity (
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
    val name: String,
    val remark: String,
    val latitude: Double,
    val longitude: Double,
)
// Convert PlaceEntity to Place
fun PlaceEntity.toDomain(): Place {
  return Place(
    id = id,
    name = name,
    remark = remark,
    latitude = latitude,
    longitude = longitude
  )

}
