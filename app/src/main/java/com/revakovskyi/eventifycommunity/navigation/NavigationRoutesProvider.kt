package com.revakovskyi.eventifycommunity.navigation

import com.revakovskyi.featureauth.navigation.AuthNavigationRoute
import com.revakovskyi.featureprofile.navigation.ProfileNavigationRoute
import com.revakovskyi.featuresplash.navigation.SplashNavigationRoute
import javax.inject.Inject

class NavigationRoutesProvider @Inject constructor(
    private val splashNavigationRoute: SplashNavigationRoute,
    private val authNavigationRoute: AuthNavigationRoute,
    private val profileNavigationRoute: ProfileNavigationRoute,
) {

    fun provideSplashNavigationRoute(): SplashNavigationRoute = splashNavigationRoute

    fun provideAuthNavigationRoute(): AuthNavigationRoute = authNavigationRoute

    fun provideProfileNavigationRoute(): ProfileNavigationRoute = profileNavigationRoute

}