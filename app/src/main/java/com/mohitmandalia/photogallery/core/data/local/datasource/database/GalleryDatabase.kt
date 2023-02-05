package com.mohitmandalia.photogallery.core.data.local.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohitmandalia.photogallery.galleryImage.common.data.local.datasource.dao.GalleryImageDao
import com.mohitmandalia.photogallery.core.data.local.datasource.database.GalleryDatabase.Companion.DATABASE_VERSION
import com.mohitmandalia.photogallery.galleryImage.common.data.local.datasource.model.GalleryImageEntity

/**
 *   Created by Mohit Mandalia
 */


@Database(
    entities = [(GalleryImageEntity::class)],
    version = DATABASE_VERSION,
    exportSchema = true
)
abstract class GalleryDatabase: RoomDatabase() {

    abstract fun galleryImageDao(): GalleryImageDao

    companion object {
        const val DATABASE_NAME = "gallery_db"
        const val DATABASE_VERSION = 1
    }
}