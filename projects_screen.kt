@Composable
fun ProjectsScreen() {
    var selectedCategory by remember { mutableStateOf("All") }
    
    Column {
        // Category filter buttons
        Row {
            FilterButton(text = "All", isSelected = selectedCategory == "All")
            FilterButton(text = "Unreal Engine", isSelected = selectedCategory == "Unreal Engine")
        }

        LazyColumn {
            items(filteredProjects) { project ->
                ProjectCard(project.title, project.techStack)
            }
        }
    }
}
