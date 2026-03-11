package com.antoniocostadossantos.gitrepositorieslist.core.navigation

import androidx.navigation3.runtime.NavKey
import com.antoniocostadossantos.gitrepositorieslist.domain.model.RepositoryModel
import kotlinx.serialization.Serializable

object NavigationRoutes {

    @Serializable
    data object HomeRoute : NavKey

    @Serializable
    data class RepositoryDetailRoute(val repositoryModel: RepositoryModel) : NavKey

}