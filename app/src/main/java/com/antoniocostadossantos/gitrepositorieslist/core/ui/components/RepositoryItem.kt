package com.antoniocostadossantos.gitrepositorieslist.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.antoniocostadossantos.gitrepositorieslist.R

@Composable
fun RepositoryItem(
    modifier: Modifier = Modifier,
    urlImage: String,
    repositoryName: String,
    starCount: String,
    forkCount: String,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(16.dp)),
                model = urlImage,
                contentDescription = null,
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = repositoryName,
                    style = TextStyle(
                        fontSize = 22.sp,
                    ),
                    overflow = TextOverflow.Ellipsis,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(16.dp),
                        imageVector = Icons.Outlined.Star,
                        contentDescription = null,
                    )
                    Spacer(
                        modifier = Modifier
                            .size(4.dp)
                    )
                    Text(
                        text = starCount,
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Icon(
                        modifier = Modifier
                            .size(16.dp),
                        painter = painterResource(R.drawable.arrow_split_24px),
                        contentDescription = null,
                    )
                    Spacer(
                        modifier = Modifier
                            .size(4.dp)
                    )
                    Text(
                        text = forkCount,
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                }
            }
        }

    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun RepositoryItemPreview() {
    RepositoryItem(
        urlImage = "",
        repositoryName = "Kotlin",
        starCount = "20",
        forkCount = "30"
    )
}