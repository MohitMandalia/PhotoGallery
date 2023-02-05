package com.mohitmandalia.photogallery.core.data.network.api

import com.mohitmandalia.photogallery.BuildConfig
import com.mohitmandalia.photogallery.galleryImage.common.data.network.dto.GalleryImagesDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *   Created by Mohit Mandalia
 */

interface GalleryApi {

    @GET("/api/")
    suspend fun getGalleryImages(
        @Query("q") query: String,
        @Query("key") key: String = BuildConfig.PIXABAY_API
    ): GalleryImagesDto

}