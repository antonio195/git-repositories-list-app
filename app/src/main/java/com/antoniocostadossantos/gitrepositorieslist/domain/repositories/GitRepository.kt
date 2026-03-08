package com.antoniocostadossantos.gitrepositorieslist.domain.repositories

import com.antoniocostadossantos.gitrepositorieslist.domain.model.MainGitModel
import kotlinx.coroutines.flow.Flow

interface GitRepository {

    suspend fun fetchRepositories(): Flow<MainGitModel>
}