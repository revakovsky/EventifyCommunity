package com.revakovskyi.eventifycommunity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.revakovskyi.eventifycommunity.navigation.AppNavGraph
import com.revakovskyi.eventifycommunity.ui.theme.EventifyCommunityTheme
import com.revakovskyi.featureauth.navigation.AuthNavigationRoute
import com.revakovskyi.featureprofile.navigation.ProfileNavigationRoute
import com.revakovskyi.featuresplash.navigation.SplashNavigationRoute
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var splashNavigationRoute: SplashNavigationRoute
    @Inject lateinit var authNavigationRoute: AuthNavigationRoute
    @Inject lateinit var profileNavigationRoute: ProfileNavigationRoute

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EventifyCommunityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavGraph(
                        splashNavigationRoute,
                        authNavigationRoute,
                        profileNavigationRoute
                    )
                }
            }
        }
    }

}
