package com.revakovskyi.featureauth.di

import com.revakovskyi.featureauth.presentation.signIn.GoogleAuthUiClient
import com.revakovskyi.featureauth.presentation.signIn.GoogleAuthUiClientImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class AuthBindModule {

    @Binds
    abstract fun bindGoogleAuthUiClient(googleAuthUiClientImpl: GoogleAuthUiClientImpl): GoogleAuthUiClient

}