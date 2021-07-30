package com.xmo.spots.di

import com.xmo.core.di.CoreComponent
import com.xmo.core.di.scopes.AppScope
import com.xmo.spots.BaseApp
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    fun inject(application: BaseApp)
}
