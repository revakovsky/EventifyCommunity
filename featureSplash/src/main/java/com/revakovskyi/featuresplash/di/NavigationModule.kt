package com.revakovskyi.featuresplash.di

import com.revakovskyi.featuresplash.navigation.SplashNavigationRoute
import com.revakovskyi.featuresplash.navigation.SplashNavigationRouteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    internal abstract fun bindSplashNavigationRoute(
        splashNavigationRouteImpl: SplashNavigationRouteImpl
    ): SplashNavigationRoute

}