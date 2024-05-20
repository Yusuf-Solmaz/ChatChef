package com.halilkrkn.chatchef

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.halilkrkn.chatchef.presentation.MainScreen
import com.halilkrkn.chatchef.ui.theme.ChatChefTheme
import com.halilkrkn.chatchef.ui.theme.MainBackgroundColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        init {
            System.loadLibrary("chatchef")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatChefTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MainBackgroundColor
                ) {
                    MainScreen()
                }
            }
        }
    }
}

private external fun getApiKeyFromNdk(): String

fun getApiKey() : String {
    return getApiKeyFromNdk()
}