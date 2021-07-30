package com.xmo.list.spotdetails

import com.xmo.core.base.BaseViewState

/**
 * Different states for [SpotDetailsFragment].
 *
 * @see BaseViewState
 */
sealed class SpotDetailsViewState : BaseViewState {

    /**
     * Loading spot detail info.
     */
    object Loading : SpotDetailsViewState()

    /**
     * Error on loading spot detail info.
     */
    object Error : SpotDetailsViewState()

    /**
     * Dismiss the detail view.
     */
    object Dismiss : SpotDetailsViewState()

    // ============================================================================================

    /**
     * Check if current view state is [Loading].
     *
     * @return True if is loading state, otherwise false.
     */
    fun isLoading() = this is Loading

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
