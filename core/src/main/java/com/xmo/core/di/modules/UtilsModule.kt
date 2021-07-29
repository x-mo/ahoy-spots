package com.xmo.core.di.modules

import com.xmo.core.di.CoreComponent
import com.xmo.core.utils.ThemeUtils
import com.xmo.core.utils.ThemeUtilsImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class UtilsModule {

    @Singleton
    @Binds
    abstract fun bindThemeUtils(themeUtilsImpl: ThemeUtilsImpl): ThemeUtils
}
