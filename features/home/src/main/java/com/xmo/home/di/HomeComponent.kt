package com.xmo.home.di

import com.xmo.home.HomeFragment
import com.xmo.core.di.CoreComponent
import com.xmo.core.di.scopes.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    modules = [HomeModule::class],
    dependencies = [CoreComponent::class]
)
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)
}
