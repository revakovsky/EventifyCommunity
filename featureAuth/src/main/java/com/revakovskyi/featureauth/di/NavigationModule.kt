package com.revakovskyi.featureauth.di

import com.revakovskyi.featureauth.navigation.AuthNavigationRoute
import com.revakovskyi.featureauth.navigation.AuthNavigationRouteImpl
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
    internal abstract fun bindAuthNavigationRoute(
        authNavigationRouteImpl: AuthNavigationRouteImpl
    ): AuthNavigationRoute

}