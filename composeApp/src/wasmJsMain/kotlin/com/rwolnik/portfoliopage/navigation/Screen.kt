package com.rwolnik.portfoliopage.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Projects : Screen("projects")
    object Skills : Screen("skills")
    object Contact : Screen("contact")
}
