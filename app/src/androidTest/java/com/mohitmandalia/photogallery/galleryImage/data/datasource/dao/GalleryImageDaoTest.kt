package com.mohitmandalia.photogallery.galleryImage.data.datasource.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import com.mohitmandalia.photogallery.core.data.local.datasource.database.GalleryDatabase
import com.mohitmandalia.photogallery.galleryImage.common.data.local.datasource.dao.GalleryImageDao
import com.mohitmandalia.photogallery.util.TestHelper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 *   Created by Mohit Mandalia
 */

@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalCoroutinesApi::class)
@SmallTest
class GalleryImageDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: GalleryDatabase

    private lateinit var dao: GalleryImageDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            GalleryDatabase::class.java
        ).build()

        dao = database.galleryImageDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertGalleryImage() = runTest {

        val galleryImageEntity = TestHelper.generateGalleryImageEntity()
        dao.insertGalleryImage(galleryImageEntity)
        val results = dao.getGalleryImages()
        Truth.assertThat(results).contains(galleryImageEntity)

    }

    @Test
    fun insertGalleryImages() = runTest {

        val galleryImageEntities = TestHelper.generateGalleryImageEntities()
        dao.insertGalleryImages(galleryImageEntities)
        val results = dao.getGalleryImages()
        Truth.assertThat(results).isEqualTo(galleryImageEntities)
    }

    @Test
    fun getGalleryImageById() = runTest {
        val id = 1
        val galleryImageEntity = TestHelper.generateGalleryImageEntity(id = id)
        val incorrectId = 2

        dao.insertGalleryImage(galleryImageEntity)
        dao.getGalleryImageById(id)
        val result = dao.getGalleryImageById(id)

        val correctDataResult = result.id == id
        Truth.assertThat(correctDataResult).isTrue()

        val incorrectDataResult = result.id != incorrectId
        Truth.assertThat(incorrectDataResult).isTrue()

    }
}