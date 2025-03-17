// entire file content ...
package com.powolnik.portfolio.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.powolnik.portfolio.data.ProjectDatabase
import kotlinx.coroutines.launch

class PortfolioViewModel(application: Application) : AndroidViewModel(application) {
    private val database = ProjectDatabase.getDatabase(application, viewModelScope)
    
    init {
        // Seed sample projects on first run
        viewModelScope.launch {
            if (database.projectDao().getAllProjects().isEmpty()) {
                val gameDevCategory = database.categoryDao()
                    .getAllCategories()
                    .find { it.name == "Game Development" }!!

                database.projectDao().insert(
                    Project(
                        title = "Unreal Engine Game",
                        description = "Sample project using Unreal Engine 5",
                        category_id = gameDevCategory.id!!,
                        tech_stack = "Unreal Engine, C++",
                        main_image_url = "/assets/game1.jpg"
                    )
                )
            }
        }
    }
}
