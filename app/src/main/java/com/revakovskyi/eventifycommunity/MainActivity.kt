package com.revakovskyi.eventifycommunity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.revakovskyi.eventifycommunity.navigation.AppNavGraph
import com.revakovskyi.eventifycommunity.navigation.NavigationRoutesProvider
import com.revakovskyi.eventifycommunity.ui.theme.EventifyCommunityTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationRoutesProvider: NavigationRoutesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EventifyCommunityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavGraph(navigationRoutesProvider)
                }
            }
        }
    }

}
