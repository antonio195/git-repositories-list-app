package com.antoniocostadossantos.gitrepositorieslist.presentation.features.viewmodel

import com.antoniocostadossantos.gitrepositorieslist.domain.model.RepositoryModel

data class HomeUiViewState(
    val isLoading: Boolean = false,
    val repositories: List<RepositoryModel> = emptyList(),
)