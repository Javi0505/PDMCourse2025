package com.pdmcourse.spotlyfe.data.repository

import com.pdmcourse.spotlyfe.data.database.dao.PlaceDao
import com.pdmcourse.spotlyfe.data.model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.pdmcourse.spotlyfe.data.database.entities.toDomain
import com.pdmcourse.spotlyfe.data.model.toDatabase


class PlaceRepositoryImpl(
    private val placeDao: PlaceDao
) : PlaceRepository {

    override fun getPlaces(): Flow<List<Place>> {
        return placeDao.getAll().map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun savePlace(place: Place) {
        placeDao.insert(place.toDatabase())
    }

    override suspend fun removePlace(place: Place) {
        placeDao.delete(place.toDatabase())
    }

}