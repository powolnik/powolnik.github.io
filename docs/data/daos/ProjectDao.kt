// entire file content ...
package com.powolnik.portfolio.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProjectDao {
    @Insert
    suspend fun insert(project: Project)

    @Query("SELECT * FROM projects")
    suspend fun getAllProjects(): List<Project>

    // Add more queries as needed (e.g., by category)
}
