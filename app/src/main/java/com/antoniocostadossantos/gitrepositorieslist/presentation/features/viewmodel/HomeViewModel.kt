package com.antoniocostadossantos.gitrepositorieslist.presentation.features.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniocostadossantos.gitrepositorieslist.domain.repositories.GitRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: GitRepository
) : ViewModel() {

    private val _homeViewState = MutableStateFlow(HomeUiViewState())
    val homeViewState: StateFlow<HomeUiViewState> = _homeViewState

    init {
        handleIntent(HomeIntent.LoadRepositories)
    }

    fun handleIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.LoadRepositories -> fetchRepositories()
        }
    }

    private fun fetchRepositories() {
        _homeViewState.value = _homeViewState.value.copy(
            isLoading = true
        )
        viewModelScope.launch(IO) {
            repository.fetchRepositories().collect {
                _homeViewState.value = _homeViewState.value.copy(
                    isLoading = false,
                    repositories = it.items
                )
            }

        }

    }
}