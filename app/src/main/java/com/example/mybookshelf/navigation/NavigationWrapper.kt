package com.example.mybookshelf.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mybookshelf.Screens.HomeScreen
import com.example.mybookshelf.Screens.LoginScreen

@Composable
fun NavigationWrapper() {

    val backStack=rememberNavBackStack(Routes.Login)
    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider =
            entryProvider {
                entry<Routes.Login> {
                    LoginScreen(gotoHome= {backStack.add(Routes.Home(user = it))
                    },
                        goToRegister= {
                            backStack.add(Routes.Register)
                        }
                    )
                }
                entry<Routes.Home> { key ->
                    HomeScreen( username= key.user)
                }
                entry<Routes.Register> {
                    Text("Registro")
                }
            }
    )
}




