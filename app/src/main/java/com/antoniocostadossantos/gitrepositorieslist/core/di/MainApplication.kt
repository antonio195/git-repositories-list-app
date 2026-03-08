package com.antoniocostadossantos.gitrepositorieslist.core.di

import android.app.Application
import com.antoniocostadossantos.gitrepositorieslist.data.repositories.GitRepositoryImpl
import com.antoniocostadossantos.gitrepositorieslist.domain.repositories.GitRepository
import com.antoniocostadossantos.gitrepositorieslist.presentation.features.viewmodel.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule, networkModule)
        }
    }

    private val networkModule = module {
        single {
            HttpClient(OkHttp) {
                install(ContentNegotiation) {
                    json(Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                        isLenient = true
                    })
                }
            }
        }
    }

    private val appModule = module {
        factory<GitRepository> {
            GitRepositoryImpl(get())
        }
        viewModelOf(::HomeViewModel)
    }
}