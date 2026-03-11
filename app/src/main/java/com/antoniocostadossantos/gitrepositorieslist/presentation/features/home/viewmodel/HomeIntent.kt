package com.antoniocostadossantos.gitrepositorieslist.presentation.features.home.viewmodel

sealed class HomeIntent {
    object LoadRepositories : HomeIntent()
}