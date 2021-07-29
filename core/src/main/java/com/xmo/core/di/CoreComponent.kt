package com.xmo.core.di

import android.content.Context
import com.xmo.core.di.modules.ContextModule
import com.xmo.core.di.modules.DatabaseModule
import com.xmo.core.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class
    ]
)
interface CoreComponent {

    fun context(): Context
}
