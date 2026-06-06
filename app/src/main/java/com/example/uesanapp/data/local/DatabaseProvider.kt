package com.example.uesanapp.data.local

import android.content.Context

object DatabaseProvider {
    fun repository(context: Context): CountryRepository {
        val db = AppDatabase.getInstance(context)
        return CountryRepository(db.countryDao())
    }
}
