package com.revakovskyi.eventifycommunity.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.revakovskyi.authorization.navigation.AuthNavigationRouteImpl
import com.revakovskyi.eventifycommunity.navigation.AppNavGraph
import com.revakovskyi.eventifycommunity.navigation.DependencyProvider
import com.revakovskyi.eventifycommunity.ui.theme.EventifyCommunityTheme
import com.revakovskyi.profile.navigation.ProfileNavigationRouteImpl
import com.revakovskyi.splashscreen.navigation.SplashNavigationRouteImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DependencyProvider.provideImpl(
            splashNavigationRoute = SplashNavigationRouteImpl(),
            authNavigationRoute = AuthNavigationRouteImpl(),
            profileNavigationRoute = ProfileNavigationRouteImpl()
        )

        setContent {
            EventifyCommunityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavGraph()
                }
            }
        }
    }
}
