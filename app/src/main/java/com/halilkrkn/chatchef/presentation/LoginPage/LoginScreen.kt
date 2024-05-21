package com.halilkrkn.chatchef.presentation.LoginPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.halilkrkn.chatchef.R
import com.halilkrkn.chatchef.navigation.util.AuthScreen
import com.halilkrkn.chatchef.presentation.components.ButtonComponent
import com.halilkrkn.chatchef.presentation.components.ClickableLoginTextComponent
import com.halilkrkn.chatchef.presentation.components.DividerTextComponent
import com.halilkrkn.chatchef.presentation.components.Loader
import com.halilkrkn.chatchef.presentation.components.TextFieldComponent
import com.halilkrkn.chatchef.presentation.components.PasswordFieldComponent
import com.halilkrkn.chatchef.presentation.components.UnderLinedTextComponent

@Composable
fun LoginScreen(navController: NavHostController, onLoginClick: () -> Unit = {}, onSignUpClick: () -> Unit = {}) {

    Scaffold(
        modifier = Modifier.padding(18.dp)){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            Loader(R.raw.login_anim)

            Spacer(modifier = Modifier.height(10.dp))

            TextFieldComponent("Email", painterResource(id = R.drawable.mail_icon))
            PasswordFieldComponent("Password", painterResource(id = R.drawable.lock_icon))

            Spacer(modifier = Modifier.height(30.dp))

            UnderLinedTextComponent(value = "Forgot your password?")

            Spacer(modifier = Modifier.height(120.dp))

            ButtonComponent(value = "Login", onClick = {
                onLoginClick()
                navController.navigate("BottomBar")
            })
            Spacer(modifier = Modifier.height(10.dp))

            DividerTextComponent()
            Spacer(modifier = Modifier.height(15.dp))
            ClickableLoginTextComponent(tryToLogin = false, onTextSelected = {
                onSignUpClick()
                navController.navigate(AuthScreen.Register.route)
            })

        }
    }
}


@Preview(showBackground = true,showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController(),{},{})
}