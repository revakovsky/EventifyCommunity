package com.revakovskyi.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface NavigationRoute {

    val firstsScreenRoute: String
    val navigationRouteName: String

    fun registerRoute(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController
    )

}