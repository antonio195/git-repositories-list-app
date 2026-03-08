package com.antoniocostadossantos.gitrepositorieslist.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainGitModel(
    @SerialName("items")
    val items: List<RepositoryModel>,
)