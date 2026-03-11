package com.antoniocostadossantos.gitrepositorieslist.presentation.features.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.antoniocostadossantos.gitrepositorieslist.core.ui.components.RepositoryItem
import com.antoniocostadossantos.gitrepositorieslist.domain.model.RepositoryModel
import com.antoniocostadossantos.gitrepositorieslist.presentation.features.home.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
    onSelectRepository: (RepositoryModel) -> Unit,
) {
    val uiState by viewModel.homeViewState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            if (uiState.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            if (uiState.repositories.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(
                        uiState.repositories,
                        key = { it.id }
                    ) { repository ->
                        RepositoryItem(
                            urlImage = repository.owner.avatarUrl,
                            repositoryName = repository.name,
                            starCount = repository.stargazersCount.toString(),
                            forkCount = repository.forksCount.toString(),
                            onClick = {
                                onSelectRepository(repository)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        onSelectRepository = {}
    )
}