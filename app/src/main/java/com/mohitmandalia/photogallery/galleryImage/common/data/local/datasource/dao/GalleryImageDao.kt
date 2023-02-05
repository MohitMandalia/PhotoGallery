package com.mohitmandalia.photogallery.galleryImage.common.data.local.datasource.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.mohitmandalia.photogallery.galleryImage.common.data.local.datasource.model.GalleryImageEntity

/**
 *   Created by Mohit Mandalia
 */

@Dao
interface GalleryImageDao {

    @Upsert
    suspend fun insertGalleryImage(galleryImageEntity: GalleryImageEntity)

    @Upsert
    suspend fun insertGalleryImages(galleryImageEntities: List<GalleryImageEntity>)

    @Query("SELECT * FROM gallery_image WHERE id = :id")
    suspend fun getGalleryImageById(id: Int): GalleryImageEntity

    @Query("SELECT * FROM gallery_image")
    suspend fun getGalleryImages(): List<GalleryImageEntity>
}