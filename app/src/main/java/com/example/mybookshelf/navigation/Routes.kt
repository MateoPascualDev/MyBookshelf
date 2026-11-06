package com.example.mybookshelf.navigation


import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
sealed class Routes : NavKey {

    @Serializable
    data object Login : Routes()

    @Serializable
    data class Home(val user: String):Routes() {

    }
    @Serializable
    data object Register:Routes()
}
/*class Home {
    val name:String
    public Home(name:String) {
        name=name2
    }
}*/