package com.mohitmandalia.photogallery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mohitmandalia.photogallery.galleryImage.gallerydetail.presentation.GalleryImageDetailScreen
import com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation.GalleryImageListScreen

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun NavGraph(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = Screen.GalleryImageListScreen.route
    ) {

        composable(
            route = Screen.GalleryImageListScreen.route
        ) {
            GalleryImageListScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.GalleryImageDetailScreen.routeWithArgument,
            arguments = listOf(
                navArgument(Screen.GalleryImageDetailScreen.argument) {
                    type = NavType.IntType
                }
            )
        ) {
            GalleryImageDetailScreen()
        }

    }

}