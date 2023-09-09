package com.revakovskyi.featureauth.presentation.signIn

import android.content.Intent
import android.content.IntentSender
import com.revakovskyi.featureauth.presentation.models.UserData

interface GoogleAuthUiClient {

    suspend fun getIntentSender(): IntentSender?
    suspend fun signInWithGoogleData(intent: Intent): SignInResult
    suspend fun getSignedInUser(): UserData?
    suspend fun signOut()

}