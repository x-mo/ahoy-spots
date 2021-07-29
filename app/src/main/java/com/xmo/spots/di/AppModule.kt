package com.xmo.spots.di

import android.content.Context
import com.xmo.spots.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

   @Provides
    fun provideContext(application: App): Context = application.applicationContext
}