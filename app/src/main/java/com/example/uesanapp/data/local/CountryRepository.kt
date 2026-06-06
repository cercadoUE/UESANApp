package com.example.uesanapp.data.local

import kotlinx.coroutines.flow.Flow

class CountryRepository(private val dao: CountryDao) {

    fun observeAll(): Flow<List<CountryEntity>> = dao.observeAll()

    fun observeFavorites(): Flow<List<CountryEntity>> = dao.observeFavorites()

    suspend fun toggleFavorite(name: String, current: Boolean) {
        dao.setFavorite(name, !current)
    }
}
