package com.antoniocostadossantos.gitrepositorieslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.antoniocostadossantos.gitrepositorieslist.core.navigation.NavigationRoutes
import com.antoniocostadossantos.gitrepositorieslist.core.ui.theme.GitRepositoriesListTheme
import com.antoniocostadossantos.gitrepositorieslist.presentation.features.home.ui.HomeScreen
import com.antoniocostadossantos.gitrepositorieslist.presentation.features.repositorydetail.ui.RepositoryDetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitRepositoriesListTheme {

                val backStack = rememberNavBackStack(NavigationRoutes.HomeRoute)

                NavDisplay(
                    onBack = {
                        backStack.removeLastOrNull()
                    },
                    backStack = backStack,
                    entryProvider = entryProvider {
                        entry<NavigationRoutes.HomeRoute> {
                            HomeScreen(
                                onSelectRepository = {
                                    backStack.add(NavigationRoutes.RepositoryDetailRoute(it))
                                }
                            )
                        }
                        entry<NavigationRoutes.RepositoryDetailRoute> { key ->
                            RepositoryDetailScreen(
                                popScreen = {
                                    backStack.removeLastOrNull()
                                },
                                repositoryModel = key.repositoryModel
                            )
                        }
                    }
                )
            }
        }
    }
}