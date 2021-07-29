package com.xmo.core.di.modules

import android.content.Context
import androidx.room.Room
import com.xmo.core.BuildConfig
import com.xmo.core.database.OCMDatabase
import com.xmo.core.database.migrations.MIGRATION_1_2
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideOCMDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            OCMDatabase::class.java,
            BuildConfig.OCM_DATABASE_NAME
        ).addMigrations(MIGRATION_1_2)
            .build()
}
