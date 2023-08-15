package com.revakovskyi.featureauth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.revakovskyi.core.extensions.sharedViewModel
import com.revakovskyi.core.navigation.MainRoutes
import com.revakovskyi.core.navigation.NavigationRoute
import com.revakovskyi.featureauth.presentation.AuthScreen
import com.revakovskyi.featureauth.presentation.AuthScreen2
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

            composable(route = firstsScreenRoute) {
                val viewModel: AuthViewModel = it.sharedViewModel(navController = navHostController)
                SignInScreen(
                    navController = navHostController,
                    viewModel = viewModel
                )
            }

            composable(route = Screens.ForgotPasswordScreen.route) {
                val viewModel: AuthViewModel = it.sharedViewModel(navController = navHostController)
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

            composable(
                route = Screens.EmailAndPhoneVerificationScreen.route,
                arguments = listOf(
                    navArgument(VERIFICATION_ARGUMENT_KEY) { type = NavType.StringType }
                )
            ) {
                EmailAndPhoneVerificationScreen(
                    navController = navHostController,
                    emailOrPhoneNumber = it.arguments?.getString(VERIFICATION_ARGUMENT_KEY)
                )
            }





            composable(route = Screens.AuthScreen.route) {
                AuthScreen(navController = navHostController)
            }

            composable(
                route = Screens.AuthScreen2.route,
                arguments = listOf(
                    navArgument(AUTH2_ARGUMENT_KEY) {
                        type = NavType.StringType
                        defaultValue = "Nothing was passed"
                    }
                )
            ) { navBackStackEntry ->
                AuthScreen2(
                    navController = navHostController,
                    text = navBackStackEntry.arguments?.getString(AUTH2_ARGUMENT_KEY)
                )
            }

        }
    }

}