package com.xmo.home


sealed class HomeViewState {

    /**
     * Full screen mode.
     */
    object FullScreen : HomeViewState()

    /**
     * Navigation screen mode.
     */
    object NavigationScreen : HomeViewState()


    fun isFullScreen() = this is FullScreen


    fun isNavigationScreen() = this is NavigationScreen
}
