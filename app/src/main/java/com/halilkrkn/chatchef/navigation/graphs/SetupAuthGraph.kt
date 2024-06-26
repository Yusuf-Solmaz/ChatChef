package com.halilkrkn.chatchef.navigation.graphs

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.halilkrkn.chatchef.navigation.util.AuthScreen
import com.halilkrkn.chatchef.navigation.util.Graph
import com.halilkrkn.chatchef.presentation.loginScreen.LoginScreen
import com.halilkrkn.chatchef.presentation.loginScreen.SignUpScreen
import com.halilkrkn.chatchef.presentation.MainScreen
import com.halilkrkn.chatchef.presentation.loginScreen.ForgotPasswordScreen

@Composable
fun SetupAuthGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route,
        modifier = modifier
    ){

        composable(route = AuthScreen.Login.route){
            LoginScreen(navController = navController)
        }

        composable(route = AuthScreen.ForgotPasswordScreen.route){
            ForgotPasswordScreen(navController = navController)
        }

        composable(route = AuthScreen.Register.route){
            SignUpScreen(navController = navController)
        }

        composable(route = Graph.BOTTOMBAR){
            MainScreen()
        }
    }
}