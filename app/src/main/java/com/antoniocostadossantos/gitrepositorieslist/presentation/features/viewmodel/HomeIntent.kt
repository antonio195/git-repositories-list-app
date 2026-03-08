package com.antoniocostadossantos.gitrepositorieslist.presentation.features.viewmodel

sealed class HomeIntent {
    object LoadRepositories : HomeIntent()
}