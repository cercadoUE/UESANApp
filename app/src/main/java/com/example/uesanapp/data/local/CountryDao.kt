package com.example.uesanapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Query("SELECT * FROM countries ORDER BY ranking ASC")
    fun observeAll(): Flow<List<CountryEntity>>

    @Query("SELECT * FROM countries WHERE isFavorite = 1 ORDER BY ranking ASC")
    fun observeFavorites(): Flow<List<CountryEntity>>

    @Query("SELECT * FROM countries ORDER BY ranking ASC")
    suspend fun getAllOnce(): List<CountryEntity>

    @Query("SELECT COUNT(*) FROM countries")
    suspend fun count(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(countries: List<CountryEntity>)

    @Query("UPDATE countries SET isFavorite = :favorite WHERE name = :name")
    suspend fun setFavorite(name: String, favorite: Boolean)
}
