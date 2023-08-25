package com.revakovskyi.featureauth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.revakovskyi.core.extensions.openAnimatedComposable
import com.revakovskyi.core.extensions.sharedViewModel
import com.revakovskyi.core.extensions.slideInFromBottomToTop
import com.revakovskyi.core.extensions.slideOutFromTopToBottom
import com.revakovskyi.core.navigation.MainRoutes
import com.revakovskyi.core.navigation.NavigationRoute
import com.revakovskyi.featureauth.presentation.screens.EmailAndPhoneVerificationScreen
import com.revakovskyi.featureauth.presentation.screens.ForgotPasswordScreen
import com.revakovskyi.featureauth.presentation.screens.SignInScreen
import com.revakovskyi.featureauth.presentation.screens.SignUpScreen
import com.revakovskyi.featureauth.viewModel.AuthViewModel
import javax.inject.Inject

interface AuthNavigationRoute : NavigationRoute


internal class AuthNavigationRouteImpl @Inject constructor() : AuthNavigationRoute {

    override val firstsScreenRoute: String
        get() = Screens.SingInScreen.route

    override val navigationRouteName: String
        get() = MainRoutes.AuthScreenRoute.route


    override fun registerRoute(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController,
    ) {
        navGraphBuilder.navigation(
            startDestination = firstsScreenRoute,
            route = navigationRouteName
        ) {

            openAnimatedComposable(route = firstsScreenRoute) { _, navBackStackEntry ->
                val viewModel: AuthViewModel = navBackStackEntry.sharedViewModel(navController = navHostController)
                SignInScreen(
                    navController = navHostController,
                    viewModel = viewModel
                )
            }

            openAnimatedComposable(
                route = Screens.ForgotPasswordScreen.route,
                enterTransition = { slideInFromBottomToTop() },
                popExitTransition = { slideOutFromTopToBottom() },
            ) { _, navBackStackEntry ->
                val viewModel: AuthViewModel = navBackStackEntry.sharedViewModel(navController = navHostController)
                ForgotPasswordScreen(
                    navController = navHostController,
                    viewModel = viewModel
                )
            }

            composable(route = Screens.SingUpScreen.route) {
                val viewModel: AuthViewModel = it.sharedViewModel(navController = navHostController)
                SignUpScreen(
                    navController = navHostController,
                    viewModel = viewModel
                )
            }

            openAnimatedComposable(
                route = Screens.EmailAndPhoneVerificationScreen.route,
                enterTransition = { slideInFromBottomToTop() },
                popExitTransition = { slideOutFromTopToBottom() },
                arguments = listOf(
                    navArgument(VERIFICATION_ARGUMENT_KEY) { type = NavType.StringType }
                )
            ) { _, navBackStackEntry ->
                EmailAndPhoneVerificationScreen(
                    navController = navHostController,
                    emailOrPhoneNumber = navBackStackEntry.arguments?.getString(
                        VERIFICATION_ARGUMENT_KEY
                    )
                )
            }

        }

    }

}