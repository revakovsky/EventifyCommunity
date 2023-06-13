package com.revakovskyi.eventifycommunity.navigation

import com.revakovskyi.authorization.navigation.AuthNavigationRoute
import com.revakovskyi.profile.navigation.ProfileNavigationRoute
import com.revakovskyi.splashscreen.navigation.SplashNavigationRoute

object DependencyProvider {

    private lateinit var splashNavigationRoute: SplashNavigationRoute
    private lateinit var authNavigationRoute: AuthNavigationRoute
    private lateinit var profileNavigationRoute: ProfileNavigationRoute

    fun provideImpl(
        splashNavigationRoute: SplashNavigationRoute,
        authNavigationRoute: AuthNavigationRoute,
        profileNavigationRoute: ProfileNavigationRoute
    ) {
        this.splashNavigationRoute = splashNavigationRoute
        this.authNavigationRoute = authNavigationRoute
        this.profileNavigationRoute = profileNavigationRoute
    }

    fun splashNavigationRoute(): SplashNavigationRoute = splashNavigationRoute
    fun authNavigationRoute(): AuthNavigationRoute = authNavigationRoute
    fun profileNavigationRoute(): ProfileNavigationRoute = profileNavigationRoute

}