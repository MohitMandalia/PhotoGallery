package com.mohitmandalia.photogallery.di

import android.content.Context
import androidx.room.Room
import com.mohitmandalia.photogallery.core.data.local.datasource.database.GalleryDatabase
import com.mohitmandalia.photogallery.core.data.network.api.GalleryApi
import com.mohitmandalia.photogallery.core.dispatcher.StandardDispatchers
import com.mohitmandalia.photogallery.core.dispatcher.StandardDispatchersImpl
import com.mohitmandalia.photogallery.core.util.Constants.BASE_URL
import com.mohitmandalia.photogallery.galleryImage.common.data.local.datasource.dao.GalleryImageDao
import com.mohitmandalia.photogallery.galleryImage.common.data.network.repository.GalleryImageRepositoryImpl
import com.mohitmandalia.photogallery.galleryImage.common.domain.repository.GalleryImageRepository
import com.mohitmandalia.photogallery.galleryImage.common.domain.usecase.GetGalleryImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 *   Created by Mohit Mandalia
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGalleryDatabase(
        @ApplicationContext applicationContext: Context,
    ) = Room.databaseBuilder(
        applicationContext,
        GalleryDatabase::class.java,
        GalleryDatabase.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideGalleryApi() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(GalleryApi::class.java)

    @Provides
    @Singleton
    fun provideGalleryImageRepository(
        galleryImageDao: GalleryImageDao,
        api: GalleryApi
    ) : GalleryImageRepository {
        return GalleryImageRepositoryImpl(
            galleryImageDao = galleryImageDao,
            api = api
        )
    }

    @Provides
    @Singleton
    fun provideGetGalleryUseCase(
        repository: GalleryImageRepository,
        dispatchers: StandardDispatchers
    ) = GetGalleryImagesUseCase(repository, dispatchers)

    @Provides
    @Singleton
    fun provideStandardDispatchers(): StandardDispatchers {
        return StandardDispatchersImpl()
    }

    @Provides
    @Singleton
    fun provideGalleryImageDao(database: GalleryDatabase): GalleryImageDao {
        return database.galleryImageDao()
    }

}