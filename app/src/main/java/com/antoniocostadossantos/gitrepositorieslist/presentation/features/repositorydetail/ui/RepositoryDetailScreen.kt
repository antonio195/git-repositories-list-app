package com.antoniocostadossantos.gitrepositorieslist.presentation.features.repositorydetail.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.antoniocostadossantos.gitrepositorieslist.R
import com.antoniocostadossantos.gitrepositorieslist.domain.model.Owner
import com.antoniocostadossantos.gitrepositorieslist.domain.model.RepositoryModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepositoryDetailScreen(
    modifier: Modifier = Modifier,
    popScreen: () -> Unit,
    repositoryModel: RepositoryModel
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            Column {
                TopAppBar(
                    modifier = Modifier
                        .fillMaxWidth(),
                    title = {
                        Text(repositoryModel.name)
                    },
                    navigationIcon = {

                        IconButton(
                            onClick = { popScreen() }
                        ) {
                            Icon(
                                Icons.AutoMirrored.Outlined.ArrowBack,
                                null
                            )
                        }
                    },
                )
                HorizontalDivider()
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = repositoryModel.name,
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = repositoryModel.fullName,
                            style = TextStyle(
                                fontSize = 16.sp,
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    AsyncImage(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        model = repositoryModel.owner.avatarUrl,
                        contentDescription = null,
                    )
                }

                HorizontalDivider(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                )

                Text(
                    text = "Descriçao",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                )
                Spacer(
                    modifier = Modifier
                        .size(4.dp)
                )
                Text(
                    text = repositoryModel.description.orEmpty(),
                    style = TextStyle(
                        fontSize = 16.sp,
                    ),
                )
                Spacer(
                    modifier = Modifier
                        .size(8.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp),
                            painter = painterResource(R.drawable.leaderboard_24px),
                            contentDescription = null,
                        )
                        Text("Score:")
                        Text("${repositoryModel.score}")
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp),
                            painter = painterResource(R.drawable.eye_tracking_24px),
                            contentDescription = null,
                        )
                        Text("Watchers:")
                        Text("${repositoryModel.watchers}")
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp),
                            painter = painterResource(R.drawable.exclamation_24px),
                            contentDescription = null,
                        )

                        Text("Open issues:")
                        Text("${repositoryModel.openIssues}")
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp),
                            painter = painterResource(R.drawable.stars_24px),
                            contentDescription = null,
                        )
                        Text("Stars:")
                        Text("${repositoryModel.stargazersCount}")
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                )

            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun RepositoryDetailScreenPreview() {
    RepositoryDetailScreen(
        popScreen = {},
        repositoryModel = RepositoryModel(
            name = "Kotlin",
            description = "All Algorithms implemented in Kotlin",
            forksCount = 404,
            homepage = "",
            htmlUrl = "https://github.com/TheAlgorithms/Kotlin",
            id = 177334737,
            nodeId = "MDEwOlJlcG9zaXRvcnkxNzczMzQ3Mzc",
            stargazersCount = 1593,
            url = "https://api.github.com/repos/TheAlgorithms/Kotlin",
            openIssues = 221,
            score = 1.0,
            watchers = 12,
            fullName = "Jetbrains/kotlin",
            owner = Owner(
                avatarUrl = "https://avatars.githubusercontent.com/u/20487725?v=4",
                htmlUrl = "https://github.com/TheAlgorithms",
                login = "Jetbrains"
            )
        )
    )
}