package com.xmo.list.spotslist

import com.xmo.core.base.BaseViewState

/**
 * Different states for [SpotsListFragment].
 *
 * @see BaseViewState
 */
sealed class SpotsListViewState : BaseViewState {

    /**
     * Loading spot detail info.
     */
    object Loading : SpotsListViewState()

    object Loaded : SpotsListViewState()

    /**
     * Error on loading spot detail info.
     */
    object Error : SpotsListViewState()

    /**
     * Dismiss the detail view.
     */
    object Dismiss : SpotsListViewState()

    // ============================================================================================

    /**
     * Check if current view state is [Loading].
     *
     * @return True if is loading state, otherwise false.
     */
    fun isLoading() = this is Loading


    fun isLoaded() = this is Loaded

    /**
     * Check if current view state is [Error].
     *
     * @return True if is error state, otherwise false.
     */
    fun isError() = this is Error


    /**
     * Check if current view state is [Dismiss].
     *
     * @return True if is delete state, otherwise false.
     */
    fun isDismiss() = this is Dismiss
}
