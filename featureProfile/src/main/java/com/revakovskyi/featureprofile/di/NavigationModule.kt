package com.revakovskyi.featureprofile.di

import com.revakovskyi.featureprofile.navigation.ProfileNavigationRoute
import com.revakovskyi.featureprofile.navigation.ProfileNavigationRouteImpl
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
    internal abstract fun bindProfileNavigationRoute(
        profileNavigationRouteImpl: ProfileNavigationRouteImpl
    ): ProfileNavigationRoute

}