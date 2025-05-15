package com.example.starwarsoracle.di

import com.example.starwarsoracle.api.StarWarsApiService
import com.example.starwarsoracle.domain.StarWarsRepository
import com.example.starwarsoracle.domain.StarWarsRepositoryImpl
import com.example.starwarsoracle.utils.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
object StarWarsOracleModule {

    @Provides
    @Singleton
    fun provideFilmRepository(
        starWarsApiService: StarWarsApiService
    ) : StarWarsRepository
    =  StarWarsRepositoryImpl(starWarsApiService)

    @Provides
    @Singleton
    fun provideApi() :  StarWarsApiService {

        val contentType = "application/json".toMediaType()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
            .create(StarWarsApiService::class.java)
    }


}