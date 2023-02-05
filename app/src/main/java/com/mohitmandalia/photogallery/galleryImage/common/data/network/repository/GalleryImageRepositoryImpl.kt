package com.mohitmandalia.photogallery.galleryImage.common.data.network.repository

import com.mohitmandalia.photogallery.galleryImage.common.data.local.datasource.dao.GalleryImageDao
import com.mohitmandalia.photogallery.galleryImage.common.data.local.datasource.model.toGalleryImage
import com.mohitmandalia.photogallery.galleryImage.common.data.mapper.toGalleryEntity
import com.mohitmandalia.photogallery.galleryImage.common.data.mapper.toGalleryImages
import com.mohitmandalia.photogallery.core.data.network.api.GalleryApi
import com.mohitmandalia.photogallery.core.util.NetworkConnection
import com.mohitmandalia.photogallery.galleryImage.common.domain.model.GalleryImage
import com.mohitmandalia.photogallery.galleryImage.common.domain.repository.GalleryImageRepository
import com.mohitmandalia.photogallery.core.util.Resource
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 */

class GalleryImageRepositoryImpl @Inject constructor(
    private val galleryImageDao: GalleryImageDao,
    private val api: GalleryApi
) : GalleryImageRepository {

    override suspend fun getGalleryImages(query: String): Resource<List<GalleryImage>> {
        return try {
            if(NetworkConnection.isConnected()) {
                val response = api.getGalleryImages(query).toGalleryImages()
                Timber.d("GalleryImages response was success for getGalleryImages: $response")
                val galleryImageEntities = response.map {
                    it.toGalleryEntity()
                }
                galleryImageDao.insertGalleryImages(galleryImageEntities)
                Resource.Success(response)
            } else {
                val galleryImages = galleryImageDao.getGalleryImages()
                    .map {
                        it.toGalleryImage()
                    }.filter {
                        it.tags.contains(query)
                    }
                if(galleryImages.isEmpty()) {
                    Timber.d("Data from database is empty and internet is not available")
                    Resource.Error("Please check you internet connection")
                } else {
                    Timber.d("Display database from internet is not available")
                    Resource.Success(galleryImages)
                }
            }
        } catch (e: HttpException) {
            Timber.d("GalleryImages response : ${e.localizedMessage}")
            Resource.Error(e.localizedMessage ?: "Unexpected error occurred")
        } catch (e: IOException) {
            Timber.d("GalleryImages response : ${e.localizedMessage}")
            Resource.Error("Server not reachable please check your internet connection")
        }
    }

    override suspend fun getGalleryImageById(id: Int): GalleryImage {
        return galleryImageDao.getGalleryImageById(id).toGalleryImage()
    }


}