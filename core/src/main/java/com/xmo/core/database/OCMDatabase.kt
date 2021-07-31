package com.xmo.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xmo.core.BuildConfig
import com.xmo.core.database.spots.Spot
import com.xmo.core.database.spots.SpotDao

@Database(
    entities = [Spot::class],
    exportSchema = BuildConfig.OCM_DATABASE_EXPORT_SCHEMA,
    version = BuildConfig.OCM_DATABASE_VERSION
)
abstract class OCMDatabase : RoomDatabase() {

    abstract fun spotsDao(): SpotDao

}
