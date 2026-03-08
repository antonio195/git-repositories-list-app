package com.antoniocostadossantos.gitrepositorieslist.data.repositories

import com.antoniocostadossantos.gitrepositorieslist.domain.model.MainGitModel
import com.antoniocostadossantos.gitrepositorieslist.domain.repositories.GitRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GitRepositoryImpl(
    private val httpClient: HttpClient
) : GitRepository {
    override suspend fun fetchRepositories(): Flow<MainGitModel> = flow {
        val response: MainGitModel =
            httpClient.get("https://api.github.com/search/repositories?q=kotlin").body()

        emit(response)
    }
}