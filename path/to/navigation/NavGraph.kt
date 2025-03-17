// entire file content ...
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("projects") { ProjectsScreen() }
        // Add other destinations here
    }
}
