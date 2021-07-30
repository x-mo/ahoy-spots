package com.xmo.spots.di

import android.content.Context
import com.xmo.spots.BaseApp
import dagger.Module
import dagger.Provides

@Module
class AppModule {

   @Provides
    fun provideContext(application: BaseApp): Context = application.applicationContext
}