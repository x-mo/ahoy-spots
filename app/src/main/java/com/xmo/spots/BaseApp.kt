package com.xmo.spots

import android.content.Context
import com.xmo.core.utils.ThemeUtils
import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.xmo.core.di.CoreComponent
import com.xmo.core.di.DaggerCoreComponent
import com.xmo.core.di.modules.ContextModule
import com.xmo.spots.di.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random

/**
 * Base class for maintaining global application state.
 */
class BaseApp : SplitCompatApplication() {

    lateinit var coreComponent: CoreComponent

    @Inject
    lateinit var themeUtils: ThemeUtils

    companion object {
        /**
         * Obtain core dagger component.
         */
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as? BaseApp)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initCoreDependencyInjection()
        initAppDependencyInjection()
        initRandomNightMode()
    }

    private fun initAppDependencyInjection() {
        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initRandomNightMode() {
        if (BuildConfig.DEBUG) {
            themeUtils.setNightMode(Random.nextBoolean())
        }
    }
}