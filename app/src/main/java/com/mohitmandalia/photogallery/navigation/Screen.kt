package com.mohitmandalia.photogallery.navigation

/**
 *   Created by Mohit Mandalia
 */

sealed class Screen(val route: String) {

    object GalleryImageListScreen : Screen("GalleryImageListScreen")

    object GalleryImageDetailScreen : Screen("GalleryImageDetailScreen") {
        const val routeWithArgument = "GalleryImageDetailScreen/{id}"
        const val argument = "id"
    }
}
