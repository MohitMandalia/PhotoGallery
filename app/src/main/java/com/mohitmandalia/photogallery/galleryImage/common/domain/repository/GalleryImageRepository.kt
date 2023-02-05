package com.mohitmandalia.photogallery.galleryImage.common.domain.repository

import com.mohitmandalia.photogallery.galleryImage.common.domain.model.GalleryImage
import com.mohitmandalia.photogallery.core.util.Resource

/**
 *   Created by Mohit Mandalia
 */
interface GalleryImageRepository {

    suspend fun getGalleryImages(query: String): Resource<List<GalleryImage>>

    suspend fun getGalleryImageById(id: Int): GalleryImage

}