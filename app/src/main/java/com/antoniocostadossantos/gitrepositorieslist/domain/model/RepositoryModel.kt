package com.antoniocostadossantos.gitrepositorieslist.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepositoryModel(

    @SerialName("name")
    val name: String,

    @SerialName("description")
    val description: String?,

    @SerialName("forks_count")
    val forksCount: Int,

    @SerialName("homepage")
    val homepage: String?,

    @SerialName("html_url")
    val htmlUrl: String,
    @SerialName("id")
    val id: Int,

    @SerialName("node_id")
    val nodeId: String,

    @SerialName("stargazers_count")
    val stargazersCount: Int,

    @SerialName("url")
    val url: String,

    @SerialName("owner")
    val owner: Owner,
)