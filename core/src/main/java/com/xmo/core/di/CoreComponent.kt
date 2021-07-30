package com.xmo.core.di

import android.content.Context
import com.xmo.core.di.modules.ContextModule
import com.xmo.core.di.modules.DatabaseModule
import com.xmo.core.di.modules.NetworkModule
import com.xmo.core.di.modules.UtilsModule
import com.xmo.core.network.repositiories.OCMRepository
import com.xmo.core.network.services.OCMService
import com.xmo.core.utils.ThemeUtils
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        UtilsModule::class
    ]
)
interface CoreComponent {

    fun context(): Context

    fun ocmService(): OCMService

    fun ocmRepository(): OCMRepository

//    fun spotsDao(): SpotsDao

    fun themeUtils(): ThemeUtils
}
